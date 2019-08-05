package DriverUtilities;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Configuration for a test run
 */
public final class Configuration {

	private Configuration() {
	}

	public static DesiredCapabilities customCaps = new DesiredCapabilities();
}