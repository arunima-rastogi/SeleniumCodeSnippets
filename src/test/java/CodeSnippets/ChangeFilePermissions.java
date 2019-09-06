package CodeSnippets;

import java.io.File;

public class ChangeFilePermissions {
	public static void main(String[] args) {
		File filespec = new File("C:\\Users\\srasz\\Desktop\\prj\\SeleniumCodeSnippets\\testngIAnnotationTransformer.xml");

		if (filespec.setWritable(false))
			System.out.println(filespec + " made read-only");
		else
			System.out.println("Permission denied");
		if (filespec.setWritable(true))
			System.out.println(filespec + " made writable");
		else
			System.out.println("Permission denied");

		System.out.println(filespec + " is currently " + (filespec.canWrite() ? "writable" : "read-only"));
	}
}
