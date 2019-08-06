package UtilityFunctions;

import java.util.function.Predicate;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverUtilities.getChromeDriver;

public class Wait4PageLoad {

	public static void main(String[] args) {
		getChromeDriver obj = new getChromeDriver(); // This can be DI driver instead of new
		WebDriver driver = obj.getDriver();
		
		driver.navigate().to("http://www.defectracker.com");
		WaitForPageLoad(driver);
		
		driver.quit();
	}

	static boolean WaitForPageLoad(WebDriver driver) {
		return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
	}

}
