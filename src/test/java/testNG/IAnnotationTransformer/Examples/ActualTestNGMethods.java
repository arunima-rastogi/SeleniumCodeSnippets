package testNG.IAnnotationTransformer.Examples;

import org.testng.annotations.Test;

public class ActualTestNGMethods {

	@Test
	public void myFunction() {
		System.out.println("Hello.............");
	}

	@Test
	public void test_Disabled() {
		System.out.println("Hello.............");
	}
}
