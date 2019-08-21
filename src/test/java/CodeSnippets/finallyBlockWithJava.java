package CodeSnippets;

public class finallyBlockWithJava {
	public static void main(String[] args) {
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			public void run() {
				// This is the code which get executed similar to "finally block in try/catch/finally
				System.out.println("In shutdown hook");
			}
		}, "Shutdown-thread"));
	}
}
