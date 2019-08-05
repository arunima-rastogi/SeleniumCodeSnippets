package BrowserCapabilities;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariOptions;

/**
 * Caps for Safari Technology Preview on Mac
 */
public class SafariTechPreviewCapabilities extends BaseCapabilities {

	public SafariTechPreviewCapabilities(DesiredCapabilities customCaps) {
		super(customCaps);
	}

	public MutableCapabilities get() {
		DesiredCapabilities safariCaps = DesiredCapabilities.safari();
		SafariOptions options = new SafariOptions();
		options.setUseTechnologyPreview(true);
		safariCaps.setCapability(SafariOptions.CAPABILITY, options);
		setLoggingPrefs(safariCaps);
		if (!this.customCaps.asMap().isEmpty()) {
			safariCaps.merge(this.customCaps);
		}
		return safariCaps;
	}
}
