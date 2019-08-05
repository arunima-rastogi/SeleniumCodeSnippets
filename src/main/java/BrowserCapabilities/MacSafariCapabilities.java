package BrowserCapabilities;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariOptions;

public class MacSafariCapabilities extends BaseCapabilities {
	public MacSafariCapabilities(DesiredCapabilities customCaps) {
		super(customCaps);
	}

	@Override
	public MutableCapabilities get() {
		return new SafariOptions().merge(customCaps);
	}
}
