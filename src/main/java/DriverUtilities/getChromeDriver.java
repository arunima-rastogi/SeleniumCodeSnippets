package DriverUtilities;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

public class getChromeDriver {

	public WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", "c:/selenium/chromedriver.exe");
		String node_host = "127.0.0.1";
		String node_port = "4444";
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
		options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.addArguments("--start-maximized");
		options.addArguments("disable-infobars");

		String node_URL = "http://" + node_host + ":" + node_port + "/wd/hub";
		WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL(node_URL), options);
		} catch (MalformedURLException e) {
			System.out.println("Malformed Exception");
		}
		return driver;
	}

}
