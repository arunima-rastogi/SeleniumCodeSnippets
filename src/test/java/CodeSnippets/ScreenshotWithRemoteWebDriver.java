package CodeSnippets;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.apache.commons.io.FileUtils;
import DriverUtilities.getChromeDriver;

public class ScreenshotWithRemoteWebDriver {
	public static void main(String[] args) throws IOException {

		getChromeDriver obj = new getChromeDriver(); // This can be DI driver instead of new
		WebDriver driver = obj.getDriver();

		driver.get("http://www.google.com");
		
		 WebDriver augmentedDriver = new Augmenter().augment(driver);
	     File screenshot = ((TakesScreenshot)augmentedDriver).
	                            getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(screenshot, new File("c:\\SRTemp\\abc.png")); 
		driver.quit();
	}
}
