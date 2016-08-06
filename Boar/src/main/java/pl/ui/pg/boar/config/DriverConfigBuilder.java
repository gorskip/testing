package pl.ui.pg.boar.config;

import java.util.Map;

/**
 *
 * @author gorskip
 */
public class DriverConfigBuilder {

    private final DriverConfig driverConfig;

    public DriverConfigBuilder(int implicitWait) {
        driverConfig = new DriverConfig(implicitWait);
    }

    public DriverConfigBuilder withBrowser(String browser) {
        driverConfig.setBrowser(browser);
        return this;
    }

    public DriverConfigBuilder withCustomWaits(Map<String, Long> customWaits) {
        driverConfig.setCustomWait(customWaits);
        return this;
    }

    public DriverConfig build() {
        return driverConfig;
    }

}
