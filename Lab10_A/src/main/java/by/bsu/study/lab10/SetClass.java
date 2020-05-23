package by.bsu.study.lab10;

import java.util.*;

public class SetClass {
    private List<Integer> elements;

    public SetClass(Integer... elements) {
        this(Arrays.asList(elements));
    }

    private SetClass(List<Integer> elements) {
        this.elements = elements;
    }

    public SetClass intersect(SetClass other) {
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < this.elements.size(); i++){
            for(int j = 0; j < other.elements.size(); j++){
                if(this.elements.get(i) == other.elements.get(j)){
                    result.add(this.elements.get(i));
                }
            }
        }
        SetClass setClass = new SetClass(result);
        return setClass;
    }

    public SetClass unify(SetClass other){
        ArrayList<Integer> all = new ArrayList<>();
        for(int i = 0; i < other.elements.size(); i++){
            all.add(other.elements.get(i));
        }

        for(int j = 0; j < this.elements.size(); j++){
            all.add(this.elements.get(j));
        }

        for(int i = 0; i < all.size(); i++){
            int check = all.get(i);
            for(int j = i + 1; j < all.size(); j++){
                if(check == all.get(j)){
                    all.remove(j);
                    j--;
                }
            }
        }
        SetClass result = new SetClass(all);
        return result;
    }

    @Override
    public String toString() {
        return "Elements=" + elements;
    }
}
