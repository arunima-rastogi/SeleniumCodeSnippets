package testNG.Runtime.DataProviders.Examples;

import org.testng.annotations.DataProvider;

public class myDPClass {

	@DataProvider(name = "myDP")
	public Object[] myDP() {
		return new Object[] { "Sheetal", "Rastogi" };
	}

	@DataProvider(name = "myDP2")
	public Object[] myDP2() {
		return new Object[] { "apple", "banana", "mango" };
	}

}