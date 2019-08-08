package UtilityFunctions;

import org.apache.commons.io.FileUtils;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;
import java.io.IOException;

/**
 * Simple snippet which shows how to clone a repository from a remote source
 *
 * @author dominik.stadler at gmx.at
 */
public class CloneRemoteRepository {

	private static final String REMOTE_URL = "https://github.allstate.com/nmcch/Lightweight_Selenium_Framework.git";

	public static void main(String[] args) throws IOException, GitAPIException {

//		 prepare a new folder for the cloned repository
		 File localPath = new File("C:\\SRTemp\\");
		
		 System.out.println("Cloning from " + REMOTE_URL + " to " +
		 localPath);
		 try (Git result = Git.cloneRepository().setURI(REMOTE_URL)
		 .setCredentialsProvider(new
		 UsernamePasswordCredentialsProvider("srasz", "jackandjillwentupthehill"))
		 .setDirectory(localPath).setProgressMonitor(new
		 SimpleProgressMonitor()).call()) {
		 // Note: the call() returns an opened repository already which needs
		 // to be closed to avoid file handle leaks!
		 System.out.println("Having repository: " +
		 result.getRepository().getDirectory());
		 }
//		 FileUtils.deleteDirectory(localPath);

		//Initializes a git repository on local file system
		File dir = new File("C:\\SRTemp\\aru\\Jacky\\");
		try (Git git = Git.init().setDirectory(dir).call()) {
			System.out.println("Created a new repository at " + git.getRepository().getDirectory());
		}
//		FileUtils.deleteDirectory(dir);

		
		
	}

	private static class SimpleProgressMonitor implements ProgressMonitor {
		@Override
		public void start(int totalTasks) {
			System.out.println("Starting work on " + totalTasks + " tasks");
		}

		@Override
		public void beginTask(String title, int totalWork) {
			System.out.println("Start  " + title + ": " + totalWork);
		}

		@Override
		public void update(int completed) {
			System.out.print(completed + "-");
		}

		@Override
		public void endTask() {
			System.out.println("\\nDone");
		}

		@Override
		public boolean isCancelled() {
			return false;
		}
	}
}
