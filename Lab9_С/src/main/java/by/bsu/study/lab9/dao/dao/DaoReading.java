package by.bsu.study.lab9.dao.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DaoReading {
    public static Logger log = LogManager.getLogger(DaoReading.class.getName());

    public ArrayList<String> DaoReading(String path) throws IOException {
        ArrayList<String> strings = new ArrayList<>();
        try (FileReader fr = new FileReader(path);
             Scanner sc = new Scanner(fr)) {
            while (sc.hasNextLine()) {
                strings.add(sc.nextLine());
            }
            return strings;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return strings;
    }
}

