package CodeSnippets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ChromeWithProxy {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Resources\\chromedriver.exe");
		WebDriver driver;
		String proxy = "127.0.0.1:5000";
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-infobars");  //disables chrome is controlled by automated test software
		options.addArguments("--proxy-server=http://" + proxy);
		driver = new ChromeDriver(options);
		
		driver.get("http://www.google.co.in");
		
		driver.quit();
	}

}
