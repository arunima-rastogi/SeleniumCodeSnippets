package CodeSnippets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverExample {
public static void main(String[] args) {
	System.setProperty("webdriver.edge.driver", "C:\\softwares\\Selenium jars\\MicrosoftWebDriver.exe");
	WebDriver driver = new EdgeDriver();
	driver.get("http://www.google.co.in");
	driver.quit();
}
}
