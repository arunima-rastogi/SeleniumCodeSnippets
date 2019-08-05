package CodeSnippets;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import DriverUtilities.getChromeDriver;
import DriverUtilities.setWindowSize;

public class ResizeScreenTest {
	public static void main(String[] args) throws IOException {
		getChromeDriver obj = new getChromeDriver(); // This can be DI driver instead of new
		WebDriver driver = obj.getDriver();
		
		setWindowSize objW = new setWindowSize();  //Driver Utilities
	
		driver.get("http://www.defectracker.com");

		objW.setWindowSize(driver, 10, 20);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$");
		driver.quit();
	}

}
