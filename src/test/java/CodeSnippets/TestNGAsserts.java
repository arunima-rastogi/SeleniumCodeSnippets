package CodeSnippets;



import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import org.testng.annotations.Test;


public class TestNGAsserts {

	@Test
	public void TestNGasser() {

		assertEquals("actual", "actual", "This msg is shown if Strings are not equal");

		assertFalse(false, "This msg is shown if condition is true");
		
		assertTrue(true, "This msg is shown if condition is not true"); 
		
		assertNotEquals("actual", "expected", "This msg is shown if two strings are equal");
		
		String msg = "";
		assertNotNull(msg, "This msg is shown if Strings is null");
		
		msg = null;
		assertNull(msg, "This msg is shown if Strings is not null");
		
		
		fail("This statement marks a testng case failed");
		
		
	}

}
