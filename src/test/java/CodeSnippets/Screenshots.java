package CodeSnippets;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import DriverUtilities.getChromeDriver;

public class Screenshots {
	public static void main(String[] args) throws IOException {
		getChromeDriver obj = new getChromeDriver(); // This can be DI driver instead of new
		WebDriver driver = obj.getDriver();
		TakesScreenshot ts = (TakesScreenshot) driver; // Typecasted to TakesScreenshot
		File src = ts.getScreenshotAs(OutputType.FILE); // This line of code is to store data in stack memory where file
														// will not be stored permanently
		File des = new File(System.getProperty("user.dir")+"/target/screenshot/google.png");// Permanent Storage of data
		FileUtils.copyFile(src, des);
		
		driver.quit();
	}
}
