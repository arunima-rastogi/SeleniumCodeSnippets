package testNG.Runtime.DataProviders.Examples;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class MyIAnnotationTransformer implements IAnnotationTransformer {

	int count = 0;

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		if (testMethod.getName() != null) {
			annotation.setDataProviderClass(myDPClass.class);
			annotation.setDataProvider("myDP2");
			count++;
		}
	}
}
