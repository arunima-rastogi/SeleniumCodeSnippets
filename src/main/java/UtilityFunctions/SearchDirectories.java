package UtilityFunctions;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.RegexFileFilter;
import org.apache.commons.logging.Log;
import java.nio.file.Files;
import org.apache.commons.logging.LogFactory;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.jar.JarFile;
import java.util.regex.Pattern;

public class SearchDirectories {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<>();
		al.add("New folder2");
		ArrayList<String> al2 = new ArrayList<>();
		
		al2 = searchDirectoryByName("C:\\Users\\srasz\\Desktop\\prj\\extracthere", al, "New folder2" );
		System.out.println(al2.toString());
	}

	public static ArrayList<String> searchDirectoryByName(String baseDir, ArrayList<String> directoryLists,
			String dirName) {
		File baseDirName = new File(baseDir);
		File[] fileArray = baseDirName.listFiles();
		if (fileArray != null) {
			for (int i = 0; i < fileArray.length; i++) {
				File name = fileArray[i];
				if (name.isDirectory()) {
					if (name.toString().subSequence(name.toString().lastIndexOf("/") + 1, name.toString().length())
							.equals(dirName)) {
						directoryLists.add(name.getAbsolutePath());
					}
					searchDirectoryByName(fileArray[i].getAbsolutePath(), directoryLists, dirName);
				} else if (fileArray.length == i) {
					return null;
				}
			}
		}
		return directoryLists;
	}
}
