package CodeSnippets;

import org.testng.asserts.SoftAssert;

public class SoftAssertsExample {

	public static void main(String[] args) {
		SoftAssert softAssert = new SoftAssert();
		System.out.println("Starting test");
		softAssert.assertEquals("Hello", "Hello", "First soft assert failed");
		softAssert.assertTrue("Hello".equalsIgnoreCase("hell0"), "Second soft assert failed");
		softAssert.assertTrue("Welcome".equalsIgnoreCase("welcomeeee"), "Third soft assert failed");
		System.out.println("*** test case two executed successfully ***");
		softAssert.assertAll();
	}
}
