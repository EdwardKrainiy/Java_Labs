package by.bsu.study.lab10;

public class Main {
    public static void main(String[] args) {
        SetClass setClass = new SetClass(1,2,3,4,5);
        SetClass setClass1 = new SetClass(2,3,6,7);
        SetClass setClass2 = setClass.intersect(setClass1);
        System.out.println("Intersecting: " + setClass2.toString());
        System.out.println("Unified: " + setClass.unify(setClass1).toString());
    }
}
