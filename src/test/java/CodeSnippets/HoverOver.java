package CodeSnippets;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import DriverUtilities.getChromeDriver;

public class HoverOver {

	public static void main(String[] args) throws InterruptedException {
		getChromeDriver obj = new getChromeDriver(); // This can be DI driver instead of new
		WebDriver driver = obj.getDriver();
	    //Implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);   //
        //Specifies the amount of time the driver should wait when searching for an element if it isnot immediately present. 

		//Navigat to page
		driver.get("http://demo.guru99.com/test/newtours/");

        //Find the Home link
        WebElement link_Home = driver.findElement(By.linkText("Home"));
        WebElement td_Home = driver.findElement(By.xpath("//html/body/div"
                        + "/table/tbody/tr/td"
                        + "/table/tbody/tr/td"
                        + "/table/tbody/tr/td"
                        + "/table/tbody/tr"));

        //Perform mouseover
        Actions builder = new Actions(driver);
        Action mouseOverHome = builder.moveToElement(link_Home).build();

        //Mouseover visual
        String bgColor = td_Home.getCssValue("BACKGROUND-COLOR");
        System.out.println("Before hover: " + bgColor);
        Thread.sleep(2000);
        mouseOverHome.perform();

        System.out.println("After hover: " + bgColor);
        
        driver.quit();
	}

}
