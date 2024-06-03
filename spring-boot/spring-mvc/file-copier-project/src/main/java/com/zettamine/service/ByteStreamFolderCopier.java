package com.zettamine.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteStreamFolderCopier extends BaseFolderCopier {

	@Override
	public void copyAll(String sourceFolderPath, String destinationFolderPath) {
		File file = new File(sourceFolderPath);

        if (file.isDirectory()) {
            copyFolder(sourceFolderPath, destinationFolderPath);
        } else {
            try (InputStream fis = new FileInputStream(sourceFolderPath);
                 OutputStream fos = new FileOutputStream(destinationFolderPath)) {

                byte[] buffer = new byte[1024];
                int data = fis.read(buffer);

                while (data  != -1) {
                	System.out.println("111");
                    fos.write(buffer, 0, data);
                    data = fis.read(buffer);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

	}

}
