package by.bsu.study.lab10.dao;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        DaoReading daoReading = new DaoReading();
        ArrayList<String> ObjectsName = daoReading.DaoReading("./src/main/java/by/bsu/study/lab10/dao/text.txt");

        ArrayList<ObjectList> objects = new ArrayList<>();
        for(int i = 0; i < ObjectsName.size(); i++){
            objects.add(new ObjectList(ObjectsName.get(i)));
        }

        sorting(objects);

        for(int i = 0; i < objects.size(); i++){
            String check = objects.get(i).getName();
            for(int j = i + 1; j < objects.size(); j++){
                if(check.equals(objects.get(j).getName())){
                    objects.remove(j);
                    j--;
                }
            }
        }

        for(ObjectList obj: objects){
            System.out.println("Object name: " + obj.getName() + "\n" + "Object code: " + obj.getCode());
        }
    }

    public static void sorting(ArrayList<ObjectList> objects) {
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < objects.size(); i++) {
                if (objects.get(i).getCode() < objects.get(i - 1).getCode()) {
                    swap(objects, i, i - 1);
                    needIteration = true;
                }
            }
        }
    }

    public static void swap(ArrayList<ObjectList> objects, int i1, int i2) {
        ObjectList tmp = objects.get(i1);
        objects.set(i1, objects.get(i2));
        objects.set(i2, tmp);
    }
}



