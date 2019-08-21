package CodeSnippets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LaunchInternetExplorer {
	
	public static void main(String[] args) throws InterruptedException {
		// System.setProperty("webdriver.ie.driver",path of executable file
		// "IEDriverServer.exe")
		System.setProperty("webdriver.ie.driver", "C:\\softwares\\Selenium jars\\IEDriverServer.exe");
		// Initialize InternetExplorerDriver Instance.
		WebDriver driver = new InternetExplorerDriver();
		driver.get("https://www.google.co.in");
		System.out.println("Selenium Webdriver Script for Internet Explorer");
		driver.close();
	}
}
