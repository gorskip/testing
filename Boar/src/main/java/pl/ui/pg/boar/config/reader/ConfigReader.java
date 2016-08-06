package pl.ui.pg.boar.config.reader;

import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author gorskip
 */
public class ConfigReader extends PropReader {

    private Properties prop;

    public ConfigReader(String propFileName) throws IOException {
        init(propFileName);
    }

    private void init(String propFileName) throws IOException {
        prop = initProperties(propFileName);
    }

    public String getTestClassPath() {
        return prop.getProperty("testClassPath");
    }

    public String getTestParamsFilePath() {
        return prop.getProperty("testParamsFilePath");
    }

    public String getUsersFilePath() {
        return prop.getProperty("usersFilePath");
    }

    public String getScenarioListFilePath() {
        return prop.getProperty("scenarioListFilePath");
    }

    public String getDriverConfigPath() {
        return prop.getProperty("driverConfig");
    }
}
