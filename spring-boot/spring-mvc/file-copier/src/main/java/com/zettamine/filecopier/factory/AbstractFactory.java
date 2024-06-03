package com.zettamine.filecopier.factory;

import com.zettamine.filecopier.service.FolderCopier;

public abstract class AbstractFactory {
	public abstract FolderCopier getFolderCopier(String copierType);

}
