package testNG.IAnnotationTransformer.Examples;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class My_ITestAnnotationTransformer implements IAnnotationTransformer {
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		System.out.println(testMethod.getName() + "$$$$$$$$$$$$");
		if (testMethod.getName().contains("myFunction")) {
			System.out.println("About to disable the method called : " + testMethod.getName());
			annotation.setEnabled(false);
		}
		if (testMethod.getName().equals("test_Disabled")) {
			System.out.println("About to enable the method called : " + testMethod.getName());
			annotation.setEnabled(true);
			System.out.println("@Test enabler");
		}
	}
}
