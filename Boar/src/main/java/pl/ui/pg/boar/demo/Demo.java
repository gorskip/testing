package pl.ui.pg.boar.demo;

import java.io.IOException;
import pl.ui.pg.boar.Boar;
import pl.ui.pg.boar.config.Config;
import pl.ui.pg.boar.config.ConfigBuilder;
import pl.ui.pg.boar.config.reader.ConfigReader;
import pl.ui.pg.boar.exceptions.ConfigException;
import pl.ui.pg.boar.testdata.provider.SimpleScenariosProvider;
import pl.ui.pg.boar.testdata.provider.json.JsonTestParamsProvider;
import pl.ui.pg.boar.testdata.provider.json.JsonUserProvider;

/**
 *
 * @author gorskip
 */
public class Demo {

    public static void main(String[] args) {
        String configFilePath = args[0];
        Config config = prepareConfig(configFilePath);

        Boar boar = new Boar();
        boar
                .prepareTestParams(new JsonTestParamsProvider(config.getTestParamsFilePath()))
                .prepareUserParams(new JsonUserProvider(config.getUsersFilePath()))
                .prepareScenarios(new SimpleScenariosProvider(config.getScenarioListFilePath()))
                .prepareDriverConfiguration(config.getDriverConfigFilePath());
        boar.run();

    }

    private static Config prepareConfig(String filePath) {
        try {
            ConfigReader configReader = new ConfigReader(filePath);
            return new ConfigBuilder()
                    .withTestParamsFilePath(configReader.getTestParamsFilePath())
                    .withTestClassPath(configReader.getTestClassPath())
                    .withUsersFilePath(configReader.getUsersFilePath())
                    .withScenarioListFilePath(configReader.getScenarioListFilePath())
                    .withDriverConfigFilePath(configReader.getDriverConfigPath())
                    .build();
        } catch (IOException ex) {
            throw new ConfigException("Cannot initialize configuration");
        }
    }
}
