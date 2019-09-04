package testNG.ExecuteTestsWithCustom.Annotations;

import java.lang.reflect.AccessibleObject;
import java.util.Map;

import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

public class MyListener implements IHookable {

	@Override
	public void run(IHookCallBack cb, ITestResult itr) {

		if (isIgnoreAnnotation(getTestMethod(itr))) {
			cb.runTestMethod(itr);
		}
	}

	private boolean isIgnoreAnnotation(Object testMethod) {
		Execute ignore = ((AccessibleObject) testMethod).getDeclaredAnnotation(Execute.class);
		if (ignore == null) {
			return false;
		}
		return true;
	}

	private Object getTestMethod(ITestResult itr) {
		return itr.getMethod().getConstructorOrMethod().getMethod();
	}

	private Map<String, Object> getParameters(ITestResult testResult) {
		Object[] params = testResult.getParameters();
		Map<String, Object> param = null;
		if (params.length > 0) {
			param = (Map<String, Object>) params[0];
		}
		return param;
	}
}