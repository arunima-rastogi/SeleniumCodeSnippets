package CodeSnippets;

import java.io.File;

public class FilePermissions {
	public static void main(String[] args) {
		File f = new File("C:\\Users\\srasz\\Desktop\\prj\\SeleniumCodeSnippets\\testngIAnnotationTransformer.xml");
		System.out.println(getFilePermissions(f));
	}

	private static String getFilePermissions(File file) {

		if (file.canExecute()) {
			return "Execute";
		} else if (file.canWrite()) {
			return "Write";
		} else if (file.canRead()) {
			return "Read";
		}
		return "Read-";
	}
}
