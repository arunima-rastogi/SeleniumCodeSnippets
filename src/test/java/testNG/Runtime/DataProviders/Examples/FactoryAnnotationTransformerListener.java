package testNG.Runtime.DataProviders.Examples;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer2;
import org.testng.annotations.IConfigurationAnnotation;
import org.testng.annotations.IDataProviderAnnotation;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.ITestAnnotation;

public class FactoryAnnotationTransformerListener implements IAnnotationTransformer2 {

	@Override
	public void transform(IFactoryAnnotation annotation, Method method) {

	}

	@Override
	public void transform(IConfigurationAnnotation annotation, Class testClass, Constructor testConstructor,
			Method testMethod) {
	}

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		if (testMethod.getName() != null) {
			System.out.println(testMethod.getName());
			annotation.setDataProviderClass(myDPClass.class);
			annotation.setDataProvider("myDP2");
		}
	}

	@Override
	public void transform(IDataProviderAnnotation annotation, Method method) {
	}
}