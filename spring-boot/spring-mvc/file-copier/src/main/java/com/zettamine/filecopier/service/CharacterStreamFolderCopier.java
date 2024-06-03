package com.zettamine.filecopier.service;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamFolderCopier extends BaseFolderCopier {

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
        	try (FileReader reader = new FileReader(source);
                    FileWriter writer = new FileWriter(destination)) {
                   char[] buffer = new char[1024];
                   int length;
                   while ((length = reader.read(buffer)) != -1) {
                	   writer.write(buffer, 0, length);
                   }
               }
        }
    }

}
