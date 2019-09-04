package testNG.ConsoleReporter;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ ConsoleReporter.class, CustomReporter.class})
public class tngTest {

	@Test
	public void f1() {
		System.out.println("Hello");
		assertTrue(true);
	}

}
