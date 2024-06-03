package com.zettamine.filecopier.factory;



public  class FactoryGenerator {
	public static AbstractFactory getFactory() {
		return new FolderCopierGenerator();
   }

}
