package Selenium_WebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class sampleTest {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Browserdrivers_Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String toNavigate = System.getProperty("user.dir");

		toNavigate = toNavigate + "\\Resources\\multiselect.html";

		driver.get(toNavigate);
		
		Select we = new Select(driver.findElement(By.xpath("/html/body/select")));
		we.deselectAll();
		
		we.selectByIndex(1);
		we.selectByIndex(2);
		
		List<WebElement> s = we.getAllSelectedOptions();
		for(WebElement e: s) {
			System.out.println(e.getText()+"$$$$$$$$$$$$$$$$$$$$");
		}

		Thread.sleep(5000);
		driver.quit();
	}

}
