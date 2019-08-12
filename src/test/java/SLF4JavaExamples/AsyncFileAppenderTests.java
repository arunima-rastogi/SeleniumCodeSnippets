package SLF4JavaExamples;



import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class AsyncFileAppenderTests {
	@Test
	public void testAsyncFileAppender() {
		Logger log = Logger.getLogger(getClass());
		log.trace("TRACE message");
		log.debug("DEBUG message");
		log.info("INFO message");
		log.warn("WARN message");
		log.error("ERROR message");
	}
}