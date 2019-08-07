package CSVUtilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class ReadCSVasMapOfMaps {

	public static Map<String, Map<String, String>> getData(String fileName) {

		Map<String, Map<String, String>> fileData = new HashMap<>();

		int rowCount = 0;
		String csvRowData = null;
		try (BufferedReader csvFileData = new BufferedReader(new FileReader(fileName))) {
			if ((csvRowData = csvFileData.readLine()) != null) {
				String[] rowKeys = csvRowData.split(",");
				while ((csvRowData = csvFileData.readLine()) != null) {
					String[] testCaseNumber = csvRowData.split(",");
					Map<String, String> dataMap = new HashMap<>();
					String[] rowData = csvRowData.split(",");
					for (int i = 0; i < rowKeys.length; i++) {
						dataMap.put(rowKeys[i], rowData[i]);
					}
					fileData.put(testCaseNumber[0], dataMap);
				}

			} else {
				System.out.println("test data file contains no data....");
			}
		} catch (Exception e) {
			System.out.println("failed to read CSV file {}{}" + e + e.getMessage());
		}

		return fileData;

	}

	public static void main(String[] args) {
		System.out.println(getData("C:\\SRTemp\\abc.txt").toString());
	}

}
