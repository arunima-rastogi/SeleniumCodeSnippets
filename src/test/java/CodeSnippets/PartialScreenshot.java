package CodeSnippets;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import DriverUtilities.getChromeDriver;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

public class PartialScreenshot {

	public static void main(String[] args) throws IOException, InterruptedException {

		getChromeDriver obj = new getChromeDriver();
		WebDriver driver = obj.getDriver();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		driver.navigate().to("http://www.google.co.in");

		WebElement element = driver.findElement(By.name("q"));

		//Highlight element via Javascript
		((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", element);

		String screenShot = System.getProperty("user.dir") + "\\screenShot.png";

		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		org.openqa.selenium.Point p = element.getLocation();

		int width = element.getSize().getWidth();
		int height = element.getSize().getHeight();
		
		// Create Rectangle
        Rectangle rect = new Rectangle(width + 600, height + 600);
        
		BufferedImage img = ImageIO.read(screen);

		BufferedImage dest = img.getSubimage(p.getX()-300, p.getY()-300, rect.width, rect.height);
		

		ImageIO.write(dest, "png", screen);

		FileUtils.copyFile(screen, new File(screenShot));
		
// WebElement screenshot with Dimension
		File screen1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Point locationInIFrame = element.getLocation();
    	Dimension d = element.getSize();
		BufferedImage bImage = img.getSubimage(locationInIFrame.x, locationInIFrame.y, d.width, d.height);
		ImageIO.write(bImage, "png", screen1);

		FileUtils.copyFile(screen, new File(screenShot+"aaa"));
		

		driver.quit();
	}

}
