package CodeSnippets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CookiesExamples {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\srasz\\Desktop\\Selenium4mRemote\\chromedriver.exe");
		WebDriver driver;

		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");

		driver = new ChromeDriver(options);

		driver.get("http://www.google.co.in");
		driver.manage().deleteCookieNamed("name of cookie");
		driver.manage().deleteAllCookies();
		
		driver.quit();

	}

}
