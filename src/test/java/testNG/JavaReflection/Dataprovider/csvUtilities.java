package testNG.JavaReflection.Dataprovider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class csvUtilities {

	public static String getCSVLineText(String fileName, int rowNo) {
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

	public static int getCSVColumnCount(String fileName) {
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

	public static int getCSVRowCount(String fileName) {
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

	public static Object[][] getCSVDataAsArray(String fileName) {
		int rowCount, columnCount = rowCount = 0;
		rowCount = csvUtilities.getCSVRowCount(fileName);
		columnCount = csvUtilities.getCSVColumnCount(fileName);
		Object[][] csvArrayObj = new Object[rowCount][columnCount];
		for (int i = 0; i < rowCount; i++) {
			Object[] rowData = csvUtilities.getCSVLineText(fileName, i).split(",");
			for (int df = 0; df < rowData.length; df++) {
				csvArrayObj[i][df] = rowData[df];
			}
		}
		return csvArrayObj;
	}
}
