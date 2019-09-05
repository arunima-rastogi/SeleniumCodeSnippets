package CodeSnippets;

import java.io.File;
import java.util.Arrays;

public class RecentlyModifiedFile {

	public static void main(String[] args) {
		File f = getLatestCreatedDirectoryfromPath(System.getProperty("user.dir"));

		System.out.println(f);
		System.out.println("lastModified "+f.lastModified());
	}

	static File getLatestCreatedDirectoryfromPath(String dirPath) {
		File[] directories = new File(dirPath).listFiles(File::isDirectory);
		Long lastModified = 0L;
		File dir =null;
		for(int i=0; i<directories.length; i++) {
			Long tempLastModified = directories[i].lastModified();
			if(tempLastModified > lastModified) {
				lastModified = tempLastModified;
				dir = directories[i];
			}
		}
		
		return dir;
	}
}
