package CodeSnippets;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import DriverUtilities.getChromeDriver;

public class ExecuteAsynJavaScript {

	public static void main(String[] args) {
		getChromeDriver obj = new getChromeDriver(); // This can be DI driver instead of new
		WebDriver driver = obj.getDriver();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		try {
			driver.navigate().to("http://www.google.co.in");
		} catch (TimeoutException e) {
			System.out.println("Timeout to load google page");
		}

		driver.quit();
	}

}