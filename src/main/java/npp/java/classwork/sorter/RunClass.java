package npp.java.classwork.sorter;

import java.io.FileNotFoundException;

/**
 * Created by aleksandr on 19.04.14.
 */
public class RunClass {
    public static void main (String[] args){
        try {
            SortingTool.sort("/JavaUniver/src/main/java/npp/java/classwork/sorter/data.csv" , "/JavaUniver/src/main/java/npp/java/classwork/sorter/output.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
