package CSVUtilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Initializer {

	public String path = System.getProperty("user.dir") + "\\configs";
	private Map<String, Object> mtafTestContext = new HashMap<>();

	public Map<String, Object> readMap() throws Exception {
		try {
			File folder = new File(path);
			File[] listOfFiles = folder.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					BufferedReader reader = new BufferedReader(new FileReader(path + "\\" + listOfFiles[i].getName()));
					String line;
					if (listOfFiles[i].getName().contains("properties")) {

						while ((line = reader.readLine()) != null) {
							String[] arr = line.split("=");
							mtafTestContext.put(arr[0], arr[1]);
						}
					}

				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return mtafTestContext;
	}
}