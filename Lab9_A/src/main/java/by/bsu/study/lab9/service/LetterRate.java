package by.bsu.study.lab9.service;

import by.bsu.study.lab9.entity.Sentence;
import by.bsu.study.lab9.entity.Text;
import by.bsu.study.lab9.entity.Word;

import java.util.ArrayList;
import java.util.Arrays;

public class LetterRate {
    public void letterRate(Text text){
        ArrayList<Word> words = new ArrayList<Word>();

        for (Sentence sentence: text.getSentences()) {
            words.addAll(sentence.getSentence());
        }

        ArrayList<String> stringWords = new ArrayList<>();
        for(Word word: words){
            stringWords.add(word.toString().toLowerCase());
        }

        ArrayList<String> letters = new ArrayList<>();
        for(String word: stringWords){
            letters.addAll(Arrays.asList(word.split("")));
        }

        int counter = 1;

        for(int i = 0; i < letters.size(); i++){
            String letter = letters.get(i);
            for (int j = i + 1; j < letters.size(); j++){
                if(letter.equals(letters.get(j))){
                    counter++;
                    letters.remove(j);
                    j--;
                }
            }
            System.out.println("Буква '" + letter + "' встречалось раз: " + counter);
            counter = 1;
        }
    }
}
