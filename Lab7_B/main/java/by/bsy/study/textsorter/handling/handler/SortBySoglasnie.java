package by.bsy.study.textsorter.handling.handler;

import by.bsy.study.textsorter.handling.domain.Sentence;
import by.bsy.study.textsorter.handling.domain.Text;
import by.bsy.study.textsorter.handling.domain.Word;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Optional;

public class SortBySoglasnie {
    private static Logger log = LogManager.getLogger(SortBySoglasnie.class.getName());

    private Text text;

    public SortBySoglasnie(Text text){
        this.text = text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public Text getText() {
        return text;
    }

    public ArrayList<Word> sortByCons() {
        ArrayList<Word> words = new ArrayList<Word>();

        for (Sentence sentence: text.getSentences()) {
            words.addAll(sentence.getSentence());
        }

        ArrayList<Word> newWords = new ArrayList<Word>();

        for(int i = 0; i < words.size(); i++){
            if(words.get(i).toString().matches("^(?i:[aeiouy]).*")){
                newWords.add(words.get(i));
            }
        }

        ArrayList<Word> sorted = new ArrayList<Word>();

        newWords.stream().sorted((word1, word2)->{
            Optional<String> firstCons1 = word1.getStringSymbols().stream().filter(symbol->{
                return(!symbol.matches("[aeiouy]"));
            }).findFirst();

            Optional<String> firstCons2 = word2.getStringSymbols().stream().filter(symbol->{
                return(!symbol.matches("[aeiouy]"));
            }).findFirst();

            String sym1 = "";
            String sym2 = "";

            if(firstCons1.isPresent()){
                sym1 = firstCons1.get();
            }

            if(firstCons2.isPresent()){
                sym2 = firstCons2.get();
            }

            return CharSequence.compare(sym1, sym2);
        }).forEachOrdered(sorted::add);

        return sorted;
    }
}
