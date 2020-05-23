package by.bsy.study.textsorter.presentation;

import by.bsy.study.textsorter.handling.domain.Word;
import by.bsy.study.textsorter.handling.domain.Text;
import by.bsy.study.textsorter.handling.handler.SortBySoglasnie;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleMenu {
    private static Logger log = LogManager.getLogger(ConsoleMenu.class.getName());

    public static void main(String[] args) {
        ConsoleMenu menu = new ConsoleMenu();
        menu.SortTextMenu();
    }

    private void SortTextMenu(){
        Scanner sc = new Scanner(System.in);

        String textPath = "./target/production/Новая папка/example1.txt";
        Text text;
        try {
            text = new Text(textPath);
        }
        catch (IOException ex){
            log.error(ex.toString());
            return;
        }
        SortBySoglasnie handler = new SortBySoglasnie(text);

        System.out.println("\nSorted words:");
        ArrayList<Word> words = handler.sortByCons();

        for(int i = 0; i < words.size(); i++){
            System.out.println(i + ") " + words.get(i).toString());
        }
    }
}
