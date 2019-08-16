package CSVUtilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.Map;

public class csvUtilities {

	public String getCSVLineText(String fileName, int rowNo) {
		String csvRowData = null;
		int row = 0;
		try (BufferedReader csvFileData = new BufferedReader(new FileReader(fileName))) {
			while ((csvRowData = csvFileData.readLine()) != null || row <= rowNo) {
				if (row == rowNo) {
					String testCaseNumber = csvRowData;
					csvRowData = testCaseNumber;
					break;
				}
				row++;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (csvRowData != null) {
			return csvRowData;
		} else {
			return "";
		}
	}

	public int getCSVColumnCount(String fileName) {
		File file = new File(fileName);
		int columnNumberReader = 0;
		String csvRowData = null;

		try (BufferedReader csvFileData = new BufferedReader(new FileReader(file))) {

			while ((csvRowData = csvFileData.readLine()) != null) {
				String[] testCaseNumber = csvRowData.split(",");
				columnNumberReader = testCaseNumber.length;
				break;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return columnNumberReader;
	}

	public int getCSVRowCount(String fileName) {
		int linenumber = 0;
		try {
			File file = new File(fileName);
			if (file.exists()) {
				FileReader fr = new FileReader(file);
				LineNumberReader lnr = new LineNumberReader(fr);
				while (lnr.readLine() != null) {
					linenumber++;
				}
				lnr.close();
			} else {
				System.out.println("File does not exists!");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return linenumber;
	}

	public Map<String, Map<String, String>> getCSVDataAsMap(String fileName) {

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

	public Object[][] getCSVDataAsArray(String fileName) {

		int rowCount, columnCount = rowCount = 0;

		rowCount = getCSVRowCount(fileName);
		columnCount = getCSVColumnCount(fileName);

		Object[][] csvArrayObj = new Object[rowCount][columnCount];

		for (int i = 0; i < rowCount; i++) {
			Object[] rowData = getCSVLineText(fileName, i).split(",");
			for (int df = 0; df < rowData.length; df++) {
				csvArrayObj[i][df] = rowData[df];
			}
		}
		return csvArrayObj;

	}

}