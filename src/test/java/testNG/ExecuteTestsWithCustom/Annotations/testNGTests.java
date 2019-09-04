package testNG.ExecuteTestsWithCustom.Annotations;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyListener.class)
public class testNGTests {

	@Execute
	@Test
	public void myFirstTest() {
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	}

	@Test
	public void mySecondTest() {
		System.out.println("#########################################");
	}
}
