package by.bsu;

import by.bsu.dao.FileReading;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.Scanner;

public class Main {
    private static Logger logger = LogManager.getLogger();
    private static Scanner scanner = new Scanner(System.in);

    public static void main( String[] args ) {
        String text = FileReading.reader(new File("data/code.txt"));
        System.out.println(text);
        System.out.println("----------------------------------------------");
        String newText = TaskFunction.characterize(text, 15);
        System.out.println(newText);
        FileReading.saver(newText,"data/outCode.txt");
    }
}
