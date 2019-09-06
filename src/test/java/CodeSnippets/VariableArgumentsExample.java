package CodeSnippets;

public class VariableArgumentsExample {
	static int sumArrays(int[]... intArrays) {
		int sum, i, j;

		sum = 0;
		for (i = 0; i < intArrays.length; i++) {
			for (j = 0; j < intArrays[i].length; j++) {
				sum += intArrays[i][j];
			}
		}

		return (sum);
	}

	public static void main(String args[]) {
		VariableArgumentsExample va = new VariableArgumentsExample();
		int sum = 0;

		sum = VariableArgumentsExample.sumArrays(new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 }, new int[] { 100, 200 });
		System.out.println("The sum of the numbers is: " + sum);
	}
}
