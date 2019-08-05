package DriverUtilities;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class setWindowSize{
	public void setWindowSize(final WebDriver driver, final int width, final int height) {
	    try {
	        WebDriver.Window window = driver.manage().window();
	        Dimension dimension = window.getSize();
	        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
	        int newWidth = dimension.width;
	        if (width > 0) {
	            newWidth = width + dimension.width - ((Long) javascriptExecutor.executeScript("return top.innerWidth;")).intValue();
	        }
	        int newHeight = dimension.height;
	        if (height > 0) {
	            newHeight = height + dimension.height - ((Long) javascriptExecutor.executeScript("return top.innerHeight;")).intValue();
	        }
	        if (dimension.width != newWidth || dimension.height != newHeight) {
	            window.setSize(new Dimension(newWidth, newHeight));
	        }
	    } catch (WebDriverException ignored) {
	    	System.out.println(ignored.getStackTrace());
	    }
	}
}

