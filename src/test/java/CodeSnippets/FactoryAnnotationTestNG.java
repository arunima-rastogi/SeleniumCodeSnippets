package CodeSnippets;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class FactoryAnnotationTestNG {
	private int num;

	@Factory(dataProvider = "data")
	public FactoryAnnotationTestNG(int n) {
		num = n;
	}

	@DataProvider
	public static Object[][] data() {
		return new Object[][] { { 1 }, { 2 }, { 3 }, { 4 } };
	}

	@Test
	public void test() {
		System.out.println(num);
	}

	@Override
	public String toString() {
		return Integer.toString(num);
	}
}