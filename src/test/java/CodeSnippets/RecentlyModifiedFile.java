package CodeSnippets;

import java.io.File;

public class RecentlyModifiedFile {

	public static void main(String[] args) {
		File dir = getLatestCreatedDirectoryfromPath(System.getProperty("user.dir")+"\\test-output");

		System.out.println(dir);
		System.out.println("lastModified " + dir.lastModified());
		
		File f = getLatestFilefromDir(dir.toString());
		if(f == null) {
			System.out.println("No file found");
		}else {
			System.out.println(f.getName());
		}
	}

	static File getLatestCreatedDirectoryfromPath(String dirPath) {
		File[] directories = new File(dirPath).listFiles(File::isDirectory);
		Long lastModified = 0L;
		File dir = null;
		for (int i = 0; i < directories.length; i++) {
			Long tempLastModified = directories[i].lastModified();
			if (tempLastModified > lastModified) {
				lastModified = tempLastModified;
				dir = directories[i];
			}
		}

		return dir;
	}
	
	static File getLatestFilefromDir(String dirPath){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }

	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	}
	
}
