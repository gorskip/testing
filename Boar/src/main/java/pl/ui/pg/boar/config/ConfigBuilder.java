package pl.ui.pg.boar.config;

import java.io.File;

/**
 *
 * @author gorskip
 */
public class ConfigBuilder {

    private Config config;

    public ConfigBuilder withTestClassPath(String path) {
        config.setTestJar(path);
        return this;
    }

    public ConfigBuilder withTestParamsFilePath(String path) {
        config.setTestParamsFilePath(new File(path).toPath());
        return this;
    }

    public ConfigBuilder withUsersFilePath(String path) {
        config.setUsersFilePath(new File(path).toPath());
        return this;
    }

    public ConfigBuilder withScenarioListFilePath(String path) {
        config.setScenarioListFilePath(new File(path).toPath());
        return this;
    }

    public ConfigBuilder withDriverConfigFilePath(String path) {
        config.setDriverConfigFilePath(new File(path).toPath());
        return this;
    }

    public ConfigBuilder withTestPackage(String testPackage) {
        config.setTestPackage(testPackage);
        return this;
    }

    public Config build() {
        return config;
    }

}
