package testNG.EnvironmentBased.DataProvider;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.TestInstance;

public class LocalDataProvider {
	@DataProvider(name = "data-provider")
	public static Object[][] getData(@TestInstance Object object) {

		// Create a list of all methods in calling class
		List<Method> allMethods = new ArrayList<Method>(Arrays.asList(object.getClass().getMethods()));

		// filter only methods where custom annotation is present
		for (Method method : allMethods) {
			if (method.isAnnotationPresent(MethodXY.class)) {
				MethodXY annotInstance = method.getAnnotation(MethodXY.class);
				if (annotInstance.Environment().equalsIgnoreCase("Staging")) {
					return new Object[][] { { 1 }, { 2 } };
				}

			}
		}
		return new Object[][] { { 3 }, { 4 } };

	}
}