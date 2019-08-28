package testNG.DynamicTestStatus.example;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class ActualTest {

	@Test
	public void passTest()
	{
		System.out.println("Test Passed");
	}
}
