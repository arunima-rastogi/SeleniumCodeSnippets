package CodeSnippets;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverUtilities.getChromeDriver;

public class ImplicitExplicitWait {
	public static void main(String[] args) {

		getChromeDriver obj = new getChromeDriver(); // This can be DI driver instead of new
		WebDriver driver = obj.getDriver();
	    //Implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);   //
        //Specifies the amount of time the driver should wait when searching for an element if it isnot immediately present. 

		driver.navigate().to("http://www.google.co.in");
		
		//Explicit waits
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		ele.sendKeys("Implicit wait in selenium");
		
		

		driver.quit();
	}
}
