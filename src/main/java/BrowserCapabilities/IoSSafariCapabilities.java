package BrowserCapabilities;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Caps for Safari on IOS
 */
public class IoSSafariCapabilities extends BaseCapabilities {

    public IoSSafariCapabilities(DesiredCapabilities customCaps) {
        super(customCaps);
    }

    public DesiredCapabilities get() {
        DesiredCapabilities caps = getIOSSafariCaps();
        if (!this.customCaps.asMap().isEmpty()) {
            caps.merge(this.customCaps);
        }
        return caps;
    }

    private DesiredCapabilities getIOSSafariCaps() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("app", "Safari");
        caps.setCapability("platformName", "iOS");
        caps.setCapability("newCommandTimeout", "900");
        setLoggingPrefs(caps);
        return caps;
    }
}