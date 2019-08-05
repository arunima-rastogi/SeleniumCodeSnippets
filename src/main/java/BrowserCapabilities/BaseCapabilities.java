package BrowserCapabilities;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.logging.Level;

/**
 * Base abstraction representing capabilities for WebDriver initialization
 * all caps should implement a support for custom capabilities that could be passed
 * from the projects to provide custom configurations for particular browser
 */

public abstract class BaseCapabilities {
    final DesiredCapabilities customCaps;

    public BaseCapabilities(DesiredCapabilities customCaps) {
        this.customCaps = customCaps;
    }

    public abstract MutableCapabilities get();

    void setLoggingPrefs(MutableCapabilities options) {
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        options.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
    }
}