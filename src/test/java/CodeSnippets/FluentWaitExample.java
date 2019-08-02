package CodeSnippets;

import java.io.File;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import DriverUtilities.getChromeDriver;

public class FluentWaitExample {

	public static void main(String[] args) {

		getChromeDriver obj = new getChromeDriver(); // This can be DI driver instead of new
		WebDriver driver = obj.getDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		
		driver.navigate().to("http://www.google.co.in");

		// Fluent wait 
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
        							.withTimeout(Duration.ofSeconds(30))
        							.pollingEvery(Duration.ofMillis(500))
        							.ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.name("q"));
			}
		});
		if(foo.isDisplayed()) {
			foo.sendKeys("Hello Fluent wait");
		}
		driver.quit();
		System.out.println(File.separator);
	}
}
