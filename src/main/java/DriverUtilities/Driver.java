package DriverUtilities;

import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

	public Driver() {
	}

	public WebDriver init() {
		DriverFactory driverFactory;
		URL gridUrl = getGridHubUrl();
		boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless"));
		if (Boolean.parseBoolean(System.getProperty("runWithGrid"))) {
			driverFactory = new RemoteDriverFactory(System.getProperty("browser"), System.getProperty("platform"),
					Configuration.customCaps, isHeadless, gridUrl);
		} else {
			driverFactory = new StandaloneDriverFactory(System.getProperty("browser"), System.getProperty("platform"),
					Configuration.customCaps, isHeadless, gridUrl);
		}

		return driverFactory.get();
	}

	private URL getGridHubUrl() {
		URL url;
		try {
			url = new URL(System.getProperty("gridHubUrl"));
		} catch (MalformedURLException e) {
			throw new RuntimeException("Error during gridhuburl creation. For url " + System.getProperty("gridHubUrl"));
		}
		return url;
	}
}