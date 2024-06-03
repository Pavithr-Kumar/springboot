package com.zettamine.filecopier;

public class LauncherApp {

	public static void main(String[] args) {
		CopyFilesTask task = new CopyFilesTask(args);
		
		Thread thread = new Thread(task);
         thread.start();
         System.out.println("Main Method Completed");
	}

}
