package DriverUtilities;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import static org.openqa.selenium.Proxy.ProxyType.MANUAL;

public class getChromeDriver {
	private final String proxyDetails = String.format("%s:%d", "127.0.0.1", 8080);
	private Proxy proxy = null;
	private final boolean proxyEnabled = Boolean.getBoolean("proxyEnabled");
	
	public WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\softwares\\Selenium jars\\chromedriver.exe");
		String node_host = "127.0.0.1";
		String node_port = "4444";
		if(!proxyEnabled) {
			proxy = getProxy();
		}
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
		options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		if(!proxyEnabled) {
			options.setCapability(CapabilityType.PROXY, proxy);
		}
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

	public Proxy getProxy() {
		Proxy proxy = new Proxy();
		proxy.setProxyType(MANUAL);
		proxy.setHttpProxy(proxyDetails);
		proxy.setSslProxy(proxyDetails);
		return proxy;
	}
}
