package UtilityFunctions;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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
		WaitForAjaxCallToComplete(driver);
		return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
	}
	
	static boolean WaitForAjaxCallToComplete(WebDriver driver) {
		return ((Long)((JavascriptExecutor) driver).executeScript("return jQuery.active")== 0);
		
	}

}
