package testNG.ITestContext.CustomStatus;

import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public final class TestNGStatus {
	private void calculate() {
		int passed = 0;
		int failed = 0;
		int skipped = 0;

		final ITestContext testContext = Reporter.getCurrentTestResult().getTestContext();
		passed += testContext.getPassedTests().size();
		failed += testContext.getFailedTests().size();
		skipped += testContext.getSkippedTests().size();

		System.out.println("Total pass count : " + passed);
		System.out.println("Total fail count : " + failed);
		System.out.println("Total skip count : " + skipped);
	}

	@Test(priority = 1)
	public void testPass() {
		System.out.println("This test passed");
	}

	@AfterSuite
	public void printResults() {
		calculate();
	}
}