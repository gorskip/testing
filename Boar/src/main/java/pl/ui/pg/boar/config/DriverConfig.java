package pl.ui.pg.boar.config;

import java.util.Map;

/**
 *
 * @author gorskip
 */
public class DriverConfig {

    private Map<String, Long> customWaitsList;
    private String browser;
    private int implicitWait;

    DriverConfig(int implicitWait) {
        this.implicitWait = implicitWait;
    }

    public void setCustomWait(Map<String, Long> customWaitsList) {
        this.customWaitsList = customWaitsList;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public void setImplicitWait(int implicitWait) {
        this.implicitWait = implicitWait;
    }

    public Map<String, Long> getCustomWaitsList() {
        return customWaitsList;
    }

    public String getBrowser() {
        return browser;
    }

    public int getImplicitWait() {
        return implicitWait;
    }

}
