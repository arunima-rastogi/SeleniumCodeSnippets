package CodeSnippets;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import DriverUtilities.getChromeDriver;

public class ContextClick {

	public static void main(String[] args) throws AWTException  {
		getChromeDriver obj = new getChromeDriver(); // This can be DI driver instead of new
		WebDriver driver = obj.getDriver();
		driver.navigate().to("http://www.google.co.in");
		
		WebElement linkText = driver.findElement(By.xpath("//*[@id=\"gbw\"]/div/div/div[1]/div[1]/a"));

		Actions act=new Actions(driver);

		act.contextClick(linkText).perform();
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_W);	//Open in new window
		r.keyPress(KeyEvent.VK_T); // open in new tab
		r.keyRelease(KeyEvent.VK_W);
		r.keyRelease(KeyEvent.VK_T);

		driver.quit();
	}

}
