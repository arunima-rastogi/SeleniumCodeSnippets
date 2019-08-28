package testNG.JavaReflection.Dataprovider;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Actual_test {

	@DataProvider(name = "csvDataProvider")
	public Object[] myCSVDataProvider() {
		Object[][] obj = csvUtilities.getCSVDataAsArray("C:\\SRTemp\\temp\\TestData4csvUtilities.txt");
		return obj;
	}

	// Step 3: Consume above DataProvider function in your TestNG Class:
	// ------------------------------------------------------------------

	@Test(dataProvider = "csvDataProvider")
	public void display(String a, String b, String c, String d, String e) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//System.out.println(a + " : " + b + " : " + c + " : " + d + " : " + e);
		
		Method testMethod = Actual_test.class.getMethod("myCSVDataProvider", null);
		Object[][] result = (Object[][]) testMethod.invoke(new Actual_test(), null);
		for(int i=0; i<result.length;i++)
        System.out.println(Arrays.toString(result[i])); // 101
	}
}
