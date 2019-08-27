package testNG.ISuiteListener.Examples;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener3.class)
public class ISTL {

	@Test
	public void testforISuiteListener() {
		System.out.println("Jackychan");
	}
}
