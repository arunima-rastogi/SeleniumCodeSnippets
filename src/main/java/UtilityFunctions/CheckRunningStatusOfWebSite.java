package UtilityFunctions;

import java.io.IOException;
import java.net.UnknownHostException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.WebDriver;

import DriverUtilities.getChromeDriver;

public class CheckRunningStatusOfWebSite {

	public static void main(String[] args) {

		getChromeDriver obj = new getChromeDriver(); // This can be DI driver instead of new
		WebDriver driver = obj.getDriver();
		try {
			if (isSiteAccessible("http://www.defectracker.com")) {
				System.out.println("Accessible continue with testing");
			} else {
				throw new UnknownHostException();
			}
		} catch (UnknownHostException e) {
			System.out.println("Not able to access WebSite");
		}
		driver.navigate().to("http://www.defectracker.com");
		Wait4PageLoad.WaitForPageLoad(driver);
		driver.quit();

	}

	private static Boolean isSiteAccessible(String webSiteURL) {
		String href = webSiteURL;
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(href);
		HttpResponse response = null;
		try {
			response = client.execute(request);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (response.getStatusLine().getStatusCode() != 200) {
			return false;
		} else {
			return true;
		}

	}

}
