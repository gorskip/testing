package pl.ui.pg.boar.config;

import java.nio.file.Path;

/**
 *
 * @author gorskip
 */
public class Config {

    private String testJar;
    private String testPackage;
    private Path testParamsFilePath;
    private Path usersFilePath;
    private Path scenarioListFilePath;
    private Path driverConfigFilePath;

    public String getTestJar() {
        return testJar;
    }

    public void setTestJar(String testJar) {
        this.testJar = testJar;
    }

    public Path getTestParamsFilePath() {
        return testParamsFilePath;
    }

    public void setTestParamsFilePath(Path testParamsFilePath) {
        this.testParamsFilePath = testParamsFilePath;
    }

    public Path getUsersFilePath() {
        return usersFilePath;
    }

    public void setUsersFilePath(Path usersFilePath) {
        this.usersFilePath = usersFilePath;
    }

    public Path getScenarioListFilePath() {
        return scenarioListFilePath;
    }

    public void setScenarioListFilePath(Path scenarioListFilePath) {
        this.scenarioListFilePath = scenarioListFilePath;
    }

    public void setDriverConfigFilePath(Path driverConfigFilePath) {
        this.driverConfigFilePath = driverConfigFilePath;
    }

    public Path getDriverConfigFilePath() {
        return driverConfigFilePath;
    }

    public String getTestPackage() {
        return testPackage;
    }

    public void setTestPackage(String testPackage) {
        this.testPackage = testPackage;
    }

}
