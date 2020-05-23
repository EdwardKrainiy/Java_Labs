package by.bsu.study.lab9.entity;

import java.util.ArrayList;

public class Word {
    private ArrayList<Symbol> symbols;

    public Word(String word){
        setSymbols(word);
    }

    public ArrayList<Symbol> getSymbols() {
        return symbols;
    }
    public void setSymbols(String word) {
        symbols = new ArrayList<>();
        word.chars().forEachOrdered(ch -> {
            symbols.add(new Symbol((char)ch));
        });
    }
    public int getSize(){
        return symbols.size();
    }

    public Symbol getSymbol(int index){
        return symbols.get(index);
    }
    public void setSymbol(int index, Symbol symbol){
        symbols.set(index, symbol);
    }
    public void removeSymbol(int index) {
        symbols.remove(index);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Symbol symbol: symbols){
            builder.append(symbol);
        }
        return builder.toString();
    }

    public ArrayList<String> getStringSymbols(){
        ArrayList<String> symbolsString = new ArrayList<>();

        for(Symbol s: symbols){
            symbolsString.add(String.valueOf(s.getSymbol()));
        }
        return symbolsString;
    }
}
