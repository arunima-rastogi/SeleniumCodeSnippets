package CodeSnippets;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class CaptureDateTimeOfException {

	@Test
	public void AriExc() {
		int x = 1 / 0;
	}

	public String getReportGenerationDateAndTime() {
		Calendar currentdate = Calendar.getInstance();

		String reportGenerationDateAndTime = null;
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm a z");
		reportGenerationDateAndTime = formatter.format(currentdate.getTime());

		TimeZone obj = TimeZone.getTimeZone("IST");

		formatter.setTimeZone(obj);
		reportGenerationDateAndTime = formatter.format(currentdate.getTime());

		return reportGenerationDateAndTime;
	}

	@AfterMethod
	public void printError(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			Throwable testException = result.getThrowable();

			if (testException instanceof ArithmeticException) {
				System.out.println("Process your exceptions here");
			}
			String clsName = result.getTestClass().getName();
			clsName = clsName.substring(clsName.lastIndexOf(".") + 1);
			System.out.println("##[Test_case]-[" + getReportGenerationDateAndTime() + "] " + clsName + "."
					+ result.getName() + " FAILED" + " with exception =>" + testException.getMessage());
		}
	}

}