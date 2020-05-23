package by.bsu.study.lab9.dao;

import java.io.IOException;
import java.util.ArrayList;

import by.bsu.study.lab9.dao.dao.DaoReading;
import by.bsu.study.lab9.dao.dao.DaoWriting;
import by.bsu.study.lab9.dao.dao.FileCreating;
import by.bsu.study.lab9.dao.services.Formatting;


public class Main {
    public static void main(String[] args) throws IOException {
        Formatting formatting = new Formatting();
        DaoReading daoReading = new DaoReading();
        ArrayList<String> content = daoReading.DaoReading("./src/main/java/by/bsu/study/lab9/dao/dao/text.txt");
        ArrayList<String> formatted = formatting.formattingFunction(content);
        FileCreating fileCreating = new FileCreating();
        fileCreating.dirCreating("./src/main/java/by/bsu/study/lab9/dao/dao");
        fileCreating.fileCreating("./src/main/java/by/bsu/study/lab9/dao/dao/NewDir/newtext.txt");
        DaoWriting daoWriting = new DaoWriting();
        daoWriting.DaoWriting("./src/main/java/by/bsu/study/lab9/dao/dao/NewDir/newtext.txt", formatted);
    }
}
