package com.zettamine.filecopier.factory;

import com.zettamine.filecopier.constants.AppConstants;
import com.zettamine.filecopier.service.ByteStreamFolderCopier;
import com.zettamine.filecopier.service.CharacterStreamFolderCopier;
import com.zettamine.filecopier.service.FolderCopier;

public class FolderCopierGenerator extends AbstractFactory {

	@Override
	public FolderCopier getFolderCopier(String copierType) {
		if(copierType==null) {
			System.err.println("please pass a valid copier type");
			return null;
		}
		if(copierType.equals(AppConstants.BYTE_STREAM))
		return new ByteStreamFolderCopier();
		else if(copierType.equals(AppConstants.CHAR_STREAM))
		 return new CharacterStreamFolderCopier();
		else {
			System.err.println("Invalid copier type");
			return null;
		}
		
	}

}
