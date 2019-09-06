package CodeSnippets;

public class OverrideMainMethod {

	// Overloaded main method 1
	public static void main(boolean args) {
		if (args) {
			System.out.println("main() overloaded" + " method 1 Executing");
			System.out.println(args);

			// Calling overloaded main method 2
			OverrideMainMethod.main("Geeks", "For Geeks");
		}
	}

	// Overloaded main method 2
	public static void main(String a, String b) {
		System.out.println("main() overloaded" + " method 2 Executing");
		System.out.println(a + " " + b);
	}

	// Overloaded main method 3
	public static void main(int args) {
		System.out.println("main() overloaded" + " method 3 Executing");
		System.out.println(args);
	}

	// Original main()
	public static void main(String[] args) {
		System.out.println("Original main()" + " Executing");
		System.out.println("Hello");

		// Calling overloads of the main method

		// Calling overloaded main method 1
		OverrideMainMethod.main(true);

		// Calling overloaded main method 3
		OverrideMainMethod.main(987654);
	}
}
