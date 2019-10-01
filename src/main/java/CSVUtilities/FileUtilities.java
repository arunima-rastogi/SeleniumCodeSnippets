package CSVUtilities;

import java.io.File;

public class FileUtilities {
	public static String getFileNameWithoutExtension(final File f) {
		final String name = f.getName();
		final int i = name.lastIndexOf(".");
		if (i > 0) {
			return name.substring(0, i);
		}
		return name;
	}

	public static String getFileNameWithoutExtension(final String filePath) {
		return getFileNameWithoutExtension(new File(filePath));
	}

	public static String getExtension(final File f) {
		final String name = f.getName();
		final int i = name.lastIndexOf(".");
		if (i > 0) {
			return name.substring(i + 1);
		}
		return "";
	}

	public static String getExtension(final String filePath) {
		return getExtension(new File(filePath));
	}

}
