package by.bsu.study.lab9.dao.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DaoWriting {
    public static Logger log = LogManager.getLogger(DaoReading.class.getName());

    public void DaoWriting(String path, ArrayList<String> content){
        try(FileWriter writer = new FileWriter(path, false)) {
            for(String line: content){
                writer.write(line);
                writer.append('\n');
            }
        }catch (IOException e){
            log.error(e.getMessage());
        }
    }
}
