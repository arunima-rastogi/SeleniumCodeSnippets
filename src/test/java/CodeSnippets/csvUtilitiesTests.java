package CodeSnippets;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

import CSVUtilities.csvUtilities;

public class csvUtilitiesTests {

	public static void main(String[] args) {
		csvUtilities obj = new csvUtilities();

		int colcount = obj.getCSVColumnCount("C:\\SRTemp\\sample.txt");
		System.out.println(colcount);
		
		String row2Text = obj.getCSVLineText("C:\\SRTemp\\sample.txt", 2);
		System.out.println(row2Text);
		
		int rowcount = obj.getCSVRowCount("C:\\SRTemp\\sample.txt");
		System.out.println(rowcount);
		
		Map<String, Map<String, String>> myMap = obj.getCSVDataAsMap("C:\\SRTemp\\sample.txt");
		System.out.println(myMap);
		
		Object[][] myArray = obj.getCSVDataAsArray("C:\\SRTemp\\sample.txt");
		for(int c=0; c<colcount; c++) {
			for(int r=0; r<rowcount;r++) {
				System.out.print(myArray[c][r]);
			}
		}
	}

}
