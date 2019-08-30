package testNG.IHookable.TochangeParameters;

import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HookableExample implements IHookable {

	@Override
	public void run(IHookCallBack callBack, ITestResult testResult) {
		Object[] parms = callBack.getParameters();  //get all parameters associated 
		if (parms[0].equals("dummy")) {
			System.out.println("Skip for parameter dummy");
		} else {
			callBack.runTestMethod(testResult);
		}
	}

}