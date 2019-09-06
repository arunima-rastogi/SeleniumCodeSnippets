package CodeSnippets;

import java.util.HashMap;

public class GetInstanceOfObject {
	public static void main(String[] args) {

		Object testObject = new HashMap();
		System.out.println(getInstance(testObject));

	}

	private static Class<?> getInstance(Object testObject) {

		return testObject.getClass();

	}
}
