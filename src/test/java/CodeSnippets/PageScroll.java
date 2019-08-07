package CodeSnippets;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import DriverUtilities.Driver;

// in order to execute this program set runtime configuration as -DrunWithGrid=false, -Dheadless=false
public class PageScroll {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\softwares\\Selenium jars\\chromedriver.exe");
		System.setProperty("gridHubUrl", "http://127.0.0.1/wd/hub");
		System.setProperty("browser", "chrome");
		System.setProperty("platform", "windows");
		
		Driver obj = new Driver();
		WebDriver driver = obj.init();
		
		driver.get("https://www.linkedin.com/");

		//scrollingToBottomofAPage
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		//Scroll to a webelement  (top of page)
		WebElement element = driver.findElement(By.xpath("/html/body/nav/a[1]/li-icon"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
		
		//Scroll by number of pixels
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
		
		
		
		driver.quit();
	}

}
