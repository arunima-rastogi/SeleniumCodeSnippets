package testNG.Runtime.DataProviders.Examples;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer2;
import org.testng.annotations.IConfigurationAnnotation;
import org.testng.annotations.IDataProviderAnnotation;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.ITestAnnotation;

public class DataProviderAnnotationTransformerListener implements IAnnotationTransformer2 {

	@Override
	public void transform(IDataProviderAnnotation annotation, Method method) {
		if (annotation.getName().equals("myDP")) {
			System.out.println("In myDP, run parallely");
			annotation.setParallel(true);
			annotation.setName("myDP2");

		}
	}

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
	}

	@Override
	public void transform(IFactoryAnnotation annotation, Method method) {
	}

	@Override
	public void transform(IConfigurationAnnotation annotation, Class testClass, Constructor testConstructor,
			Method testMethod) {
	}
}