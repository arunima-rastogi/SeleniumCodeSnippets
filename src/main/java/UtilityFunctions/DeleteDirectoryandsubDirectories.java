package UtilityFunctions;

import java.io.File;
import org.testng.annotations.Test;

public class DeleteDirectoryandsubDirectories {

	@Test
	public void GuiTest() {
		System.out.println("Gui test done");
		File dir = new File("C:\\SRTemp\\temp\\todelete");
		deleteDir(dir);

	}

	public static boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			if (children != null) {
				for (String child : children) {
					boolean success = deleteDir(new File(dir, child));
					if (!success) {
						return false;
					}
				}
			}
		}

		// The directory is now empty so delete it
		return dir.delete();
	}
}
