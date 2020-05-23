package by.bsu.study.lab9.dao.dao;

import java.io.File;
import java.io.IOException;

public class FileCreating {
    public void dirCreating(String path) throws IOException {
        File folder = new File(path + "//NewDir");
        if (!folder.exists()) {
            folder.mkdir();
            System.out.println("Directory " + path + "//NewDir was created successfully!");
        }
    }

    public void fileCreating(String path) throws IOException {
        File file = new File(path);
        if(!file.exists()){
            file.createNewFile();
        }
    }
}
