package CodeSnippets;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WorkingWithTabs {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\srasz\\Desktop\\Selenium4mRemote\\chromedriver.exe");
		WebDriver driver;

		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");

		driver = new ChromeDriver(options);

		driver.get("http://www.google.co.in");

		String a = "window.open('about:blank','_blank');";  // Create a tab
		((JavascriptExecutor) driver).executeScript(a);

		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1)); // switch to first tab
		driver.get("http://www.amazon.co.in");
		driver.close();
		driver.switchTo().window(tabs2.get(0)); // switch back to initial tab

		Thread.sleep(2000);

		driver.quit();

	}

}
