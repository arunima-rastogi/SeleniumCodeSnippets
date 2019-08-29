package testNG.Native.DepInj;

import org.testng.IInvokedMethod;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TngEample {

	@Test
	public void exTest() {
		int x = 1/0;
	}
	
	@AfterTest
	public Throwable atTestContext(ITestContext context) {
        for (IInvokedMethod method : context.getSuite().getAllInvokedMethods()) {
            ITestNGMethod m = method.getTestMethod();
            if (m.isTest() && (!method.getTestResult().isSuccess())) {
            	System.out.println("$$$$$$$$$$$$$$$$$$$$$$$");
                return method.getTestResult().getThrowable();
            }
        }
        return null;
	}
}
