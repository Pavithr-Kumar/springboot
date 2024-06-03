package com.zettamine.filecopier;

import com.zettamine.filecopier.constants.AppConstants;
import com.zettamine.filecopier.factory.AbstractFactory;
import com.zettamine.filecopier.factory.FactoryGenerator;
import com.zettamine.filecopier.service.FolderCopier;

public class CopyFilesTask implements Runnable {
	
	private String[] args;
	
	

	public CopyFilesTask(String[] args) {
		this.args=args;
	}


	@Override
	public void run() {
		AbstractFactory factory= FactoryGenerator.getFactory();
		FolderCopier folderCopier = factory.getFolderCopier(AppConstants.BYTE_STREAM);
		folderCopier.replicate(args[0], args[1]);
		System.out.println("Run Method Completed");

	}

}
