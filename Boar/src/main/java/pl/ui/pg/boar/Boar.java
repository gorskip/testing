package pl.ui.pg.boar;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import pl.ui.pg.boar.config.DriverConfig;
import pl.ui.pg.boar.config.DriverConfigBuilder;
import pl.ui.pg.boar.config.loader.XmlClassLoader;
import pl.ui.pg.boar.config.reader.DriverConfigReader;
import pl.ui.pg.boar.exceptions.UserWithRoleNotProvidedException;
import pl.ui.pg.boar.testdata.data.TestParams;
import pl.ui.pg.boar.testdata.provider.ScenariosProvider;
import pl.ui.pg.boar.testdata.provider.TestParamsProvider;
import pl.ui.pg.boar.testdata.provider.UserProvider;
import pl.ui.pg.boar.testdata.user.User;
import pl.ui.pg.boar.utils.TextUtils;

/**
 *
 * @author gorskip
 */
public class Boar {

    private DriverConfig driverConfig;
    private List<TestParams> testParams;
    private List<User> users;
    private List<String> scenarios;
    private String jarPath;
    private List<XmlClass> xmlClasses;

    public Boar setDriverConfiguration(Path driverConfigPath) {
        try {
            DriverConfigReader driverConfigReader = new DriverConfigReader(driverConfigPath);
            driverConfig = new DriverConfigBuilder(driverConfigReader.getImplicitWait())
                    .withBrowser(driverConfigReader.getBrowser())
                    .withCustomWaits(driverConfigReader.getCustomWaits())
                    .build();
        } catch (IOException e) {

        }
        return this;
    }

    public Boar setTestParams(TestParamsProvider testParamsProvider) {
        testParams = testParamsProvider.build();
        return this;

    }

    public Boar setUserParams(UserProvider userProvider) {
        users = userProvider.build();
        return this;
    }

    public Boar setScenarios(ScenariosProvider scenariosProvider) {
        scenarios = scenariosProvider.build();
        return this;
    }

    public Boar setTestJar(String testJarPath, String testPackage) {
        jarPath = testJarPath;
        xmlClasses = new XmlClassLoader().load(jarPath, testPackage);
        return this;
    }

    public void run() {
        start(getTestParamsForTests());
    }

    private List<TestParams> getTestParamsForTests() {
        List<TestParams> testParamsToTests = new ArrayList<>();
        for (TestParams testParam : testParams) {
            if (TextUtils.equalsAny(testParam.getId(), scenarios.toArray(new String[scenarios.size()]))) {
                testParamsToTests.add(testParam);
            }
        }
        return testParamsToTests;
    }

    private void start(List<TestParams> tests) {
        for (TestParams testParamToTest : tests) {
            executeTest(testParamToTest, getUser(testParamToTest.getUserRoles()));
        }
    }

    private User getUser(List<String> userRoles) {
        for (User user : users) {
            if (user.hasAllRoles(userRoles)) {
                return user;
            }
        }
        throw new UserWithRoleNotProvidedException("Cannot find user with roles: " + userRoles);
    }

    private void executeTest(TestParams testParamToTest, User user) {
        TestNG testNG = prepareTestNG();
        testNG.run();
    }

    private TestNG prepareTestNG() {
        XmlSuite suite = new XmlSuite();
        suite.setName("Boar");
        XmlTest test = new XmlTest(suite);
        test.setName("BoarTest");
        test.setIncludedGroups(scenarios);
        test.setXmlClasses(xmlClasses);
        List<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);
        TestNG testNG = new TestNG();
        testNG.setXmlSuites(suites);
        return testNG;
    }

}
