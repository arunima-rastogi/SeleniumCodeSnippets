package testNG.EnvironmentBased.DataProvider;


import org.testng.annotations.Test;

public class SecondTestClass {
	@Test(dataProvider = "data-provider", dataProviderClass = LocalDataProvider.class)
	public void testmethod(int number) {
		System.err.println("Value = " + number);
	}
}