package by.bsu.study.lab9.dao.services;

import java.util.ArrayList;

public class Formatting {
    public ArrayList<String> formattingFunction(ArrayList<String> content){
        ArrayList<String> formatted = new ArrayList<>();
        int i = 0;
        for(; i < content.size();){
            if(content.get(i).trim().length() == 0){
                content.remove(i);
                i--;
            }
            i++;
        }

        for(int j = 0; j < content.size(); j++){
            String time = content.get(j).replaceAll("\\s+", " ");
            content.set(j, time);
        }
        return content;
    }
}
