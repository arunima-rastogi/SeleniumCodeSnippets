package CodeSnippets;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import DriverUtilities.getChromeDriver;

public class WorkingwithCookies {

	public static void main(String[] args) {
		getChromeDriver obj = new getChromeDriver();
		WebDriver driver = obj.getDriver();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		//delete cookies
		driver.manage().deleteAllCookies();
		
		driver.navigate().to("http://www.google.co.in");

		// Create a cookie that needs to be added to browser
		Cookie coo = new Cookie("cookieName", "cookieValue");
		// Add cookie to browser
		driver.manage().addCookie(coo);

		// get the cookies from the browser,
		// not only cookies we set but also the cookies set by the website
		Set<Cookie> abc = driver.manage().getCookies();

		System.out.println("Number of Cookies present : " + abc.size());
		for (Cookie cookie : abc) {
			System.out.println("---------------");
			System.out.println("Cookie Name/Value : " + cookie.getName() + ": " + cookie.getValue());
		}

		driver.quit();
	}

}
