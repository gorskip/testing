package pl.ui.pg.boar;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import pl.ui.pg.boar.config.DriverConfig;
import pl.ui.pg.boar.config.DriverConfigBuilder;
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

    public Boar prepareDriverConfiguration(Path driverConfigPath) {
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

    public Boar prepareTestParams(TestParamsProvider testParamsProvider) {
        testParams = testParamsProvider.build();
        return this;

    }

    public Boar prepareUserParams(UserProvider userProvider) {
        users = userProvider.build();
        return this;
    }

    public Boar prepareScenarios(ScenariosProvider scenariosProvider) {
        scenarios = scenariosProvider.build();
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
    }

}
