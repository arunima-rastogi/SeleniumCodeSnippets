package testNG.Runtime.DataProviders.Examples;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGScript {

	@Test(dataProvider = "myDP", dataProviderClass = myDPClass.class)  //Though it is defined as myDPClass, it will be dynamic
	public void myFunction(String s0) {
		System.out.println(s0);
	}

}
