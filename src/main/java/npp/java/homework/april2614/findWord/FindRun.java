package npp.java.homework.april2614.findWord;

import java.io.*;
import java.util.LinkedList;

/**
 * Created by aleksandr on 16.05.14.
 */
public class FindRun {
    public static void main(String[] args){

        try {
            System.out.print("Begin\n");
            File file = new File("/JavaUniver/src/main/java/npp/java/homework/april2614/findWord/input.txt");
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

            LinkedList<Integer> result = Finder.findPositions(bufReader, "key".toCharArray());
            bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            LinkedList<Integer> result1 = Finder.findWordNumbers(bufReader, "key");
            System.out.print(result + "\n");
            System.out.print(result1 + "\n");
            bufReader.close();
        }
        catch (Exception e) {
            System.out.print("problem \n");
        }
    }
}
