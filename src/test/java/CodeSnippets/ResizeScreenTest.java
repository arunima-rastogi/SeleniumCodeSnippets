package CodeSnippets;


import java.io.IOException;
import org.openqa.selenium.WebDriver;
import DriverUtilities.getChromeDriver;
import DriverUtilities.setWindowSize;

public class ResizeScreenTest {
	public static void main(String[] args) throws IOException {
		getChromeDriver obj = new getChromeDriver(); // This can be DI driver instead of new
		WebDriver driver = obj.getDriver();
		
		setWindowSize objW = new setWindowSize();  //Driver Utilities
	
		driver.get("http://www.defectracker.com");

		objW.setWindowSize(driver, 10, 20);
		
		driver.quit();
	}

}
