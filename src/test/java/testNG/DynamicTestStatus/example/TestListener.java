package testNG.DynamicTestStatus.example;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;

/**
 * TestNG - Customize test results based of specifics
 * @author admin
 *
 */
public class TestListener implements IInvokedMethodListener {
	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult arg0) {
		if (arg0.getMethod().isTest()) {
			// Change Failed to Skipped based on exception text
			if (arg0.getStatus() == ITestResult.FAILURE) {
				if (arg0.getThrowable() != null) {
					if (arg0.getThrowable().getStackTrace() != null) {
						StringWriter sw = new StringWriter();
						arg0.getThrowable().printStackTrace(new PrintWriter(sw));
						if (sw.toString().contains("visible")) {
							ITestContext tc = Reporter.getCurrentTestResult().getTestContext();
							tc.getFailedTests().addResult(arg0, Reporter.getCurrentTestResult().getMethod());
							tc.getFailedTests().getAllMethods().remove(Reporter.getCurrentTestResult().getMethod());
							Reporter.getCurrentTestResult().setStatus(ITestResult.SKIP);
							tc.getSkippedTests().addResult(arg0, Reporter.getCurrentTestResult().getMethod());
						}
					}
				}
			}

			// Change Pass to failure and throw custom exception error
			if (arg0.getStatus() == ITestResult.SUCCESS) {
				ITestContext tc = Reporter.getCurrentTestResult().getTestContext();
				tc.getPassedTests().addResult(arg0, Reporter.getCurrentTestResult().getMethod());
				tc.getPassedTests().getAllMethods().remove(Reporter.getCurrentTestResult().getMethod());
				Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
				Reporter.getCurrentTestResult().setThrowable(new Exception("test Fail"));
				tc.getSkippedTests().addResult(arg0, Reporter.getCurrentTestResult().getMethod());
			}

			// Change skip to fail with custom failure
			if (arg0.getStatus() == ITestResult.SKIP) {
				ITestContext tc = Reporter.getCurrentTestResult().getTestContext();
				tc.getSkippedTests().addResult(arg0, Reporter.getCurrentTestResult().getMethod());
				tc.getSkippedTests().getAllMethods().remove(Reporter.getCurrentTestResult().getMethod());
				Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
				Reporter.getCurrentTestResult().setThrowable(new Exception("test Fail"));
				tc.getFailedTests().addResult(arg0, Reporter.getCurrentTestResult().getMethod());
			}
		}
	}
}