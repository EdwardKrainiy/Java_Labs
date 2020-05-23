package by.bsu.study.lab9;

import java.io.IOException;

import by.bsu.study.lab9.service.LetterRate;
import by.bsu.study.lab9.service.WordRate;
import by.bsu.study.lab9.entity.Text;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "./src/main/java/by/bsu/study/lab9/dao/text.txt";
        Text text = new Text(path);
        WordRate wordRate = new WordRate();
        wordRate.wordRate(text);
        System.out.println("========================================================================================================================");
        LetterRate letterRate = new LetterRate();
        letterRate.letterRate(text);
    }
}
