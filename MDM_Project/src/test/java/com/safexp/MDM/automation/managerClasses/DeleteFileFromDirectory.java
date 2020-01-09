package com.safexp.MDM.automation.managerClasses;

import java.io.File;

public class DeleteFileFromDirectory {


public static void deleteFolder(File folder) {
    File[] files = folder.listFiles();
    if(files!=null) { //some JVMs return null for empty dirs
        for(File f: files) {
            if(f.isDirectory()) {
                deleteFolder(f);
            } else {
                f.delete();
            }
        }
    }
    //folder.delete();
}
public static void main(String[] args) {
	String path=System.getProperty("user.dir")+"/Report";
	File f=new File(path);
	deleteFolder(f);
}
}