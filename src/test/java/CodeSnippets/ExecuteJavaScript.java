package CodeSnippets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import DriverUtilities.getChromeDriver;

public class ExecuteJavaScript {

	public static void main(String[] args) {
		getChromeDriver obj = new getChromeDriver(); // This can be DI driver instead of new
		WebDriver driver = obj.getDriver();
		driver.navigate().to("http://www.google.co.in");
		WebElement webElement = driver.findElement(By.xpath("(//a)[2]"));
		Object arr = ((JavascriptExecutor) driver).executeScript("var arr = []; arr[0] = document.getElementsByTagName('A')[0]; arr[1] = arguments[0]; arr[2] = arguments[1]; arr[3] = arguments[2]; arr[4] = arguments[3]; return arr;", "mystring", 22, true, webElement);

		List<Object> array = (List<Object>) arr;
		Assert.assertEquals(array.get(0).getClass().getSimpleName(), "RemoteWebElement");
		Assert.assertEquals((String) array.get(1), "mystring");
		Assert.assertEquals((Long) array.get(2), new Long(22));
		Assert.assertEquals((boolean) array.get(3), true);
		Assert.assertEquals(array.get(4).getClass().getSimpleName(), "RemoteWebElement");

		driver.quit();
	}

}
