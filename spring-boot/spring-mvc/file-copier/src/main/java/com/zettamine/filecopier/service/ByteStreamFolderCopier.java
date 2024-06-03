package com.zettamine.filecopier.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamFolderCopier implements FolderCopier {

	@Override
	public void replicate(String sourcePath, String destinationPath) {
		try {
            copyFolder(new File(sourcePath), new File(destinationPath));
            System.out.println("Folder copied successfully.");
        } catch (IOException e) {
            System.err.println("Error copying folder: " + e.getMessage());
        }
		
	}
	
	public static void copyFolder(File source, File destination) throws IOException {
        if (source.isDirectory()) {
            if (!destination.exists()) {
                destination.mkdirs();
            }

            File[] files = source.listFiles();
            for (File file : files) {
                copyFolder(file, new File(destination, file.getName()));
            }
        } else {
            try (FileInputStream inputStream = new FileInputStream(source);
                 FileOutputStream outputStream = new FileOutputStream(destination)) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer)) > 0) {
                	outputStream.write(buffer, 0, length);
                }
            }
        }
    }

	
}
