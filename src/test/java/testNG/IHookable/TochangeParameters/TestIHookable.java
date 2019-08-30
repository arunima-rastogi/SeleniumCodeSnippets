package testNG.IHookable.TochangeParameters;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(HookableExample.class)
public class TestIHookable {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite");
	}

	@Test(dataProvider = "getDp")
	public void t(String p) {
		System.out.println("test method t called with parameter " + p);
	}

	@DataProvider
	public Object[][] getDp() {
		return new Object[][] { { "client1" }, { "client2" }, { "dummy" } };
	}
}
