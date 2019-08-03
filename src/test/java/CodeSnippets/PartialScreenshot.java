package CodeSnippets;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import DriverUtilities.getChromeDriver;

public class PartialScreenshot {

	public static void main(String[] args) throws IOException {

		getChromeDriver obj = new getChromeDriver();
		WebDriver driver = obj.getDriver();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		driver.navigate().to("http://www.google.co.in");
		

		System.out.println("jack");
		WebElement element = driver.findElement(By.name("q"));

		String screenShot = System.getProperty("user.dir") + "\\screenShot.png";

		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		org.openqa.selenium.Point p = element.getLocation();

		int width = element.getSize().getWidth();
		int height = element.getSize().getHeight();

		BufferedImage img = ImageIO.read(screen);

		BufferedImage dest = img.getSubimage(p.getX(), p.getY(), width, height);

		ImageIO.write(dest, "png", screen);

		FileUtils.copyFile(screen, new File(screenShot));

		driver.quit();
	}

}
