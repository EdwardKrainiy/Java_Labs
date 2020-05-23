package by.bsu.study.lab9.service;

import java.util.ArrayList;

import by.bsu.study.lab9.entity.Sentence;
import by.bsu.study.lab9.entity.Text;
import by.bsu.study.lab9.entity.Word;

public class WordRate {
    public void wordRate(Text text){
        ArrayList<Word> words = new ArrayList<Word>();

        for (Sentence sentence: text.getSentences()) {
            words.addAll(sentence.getSentence());
        }

        ArrayList<String> stringWords = new ArrayList<>();
        for(Word word: words){
            stringWords.add(word.toString().toLowerCase());
        }

        int counter = 1;

        for(int i = 0; i < stringWords.size(); i++){
            String word = stringWords.get(i);
            for (int j = i + 1; j < stringWords.size(); j++){
                if(word.equals(stringWords.get(j))){
                    counter++;
                    stringWords.remove(j);
                    j--;
                }
            }
            System.out.println("Слово '" + word + "' встречалось раз: " + counter);
            counter = 1;
        }
    }
}
