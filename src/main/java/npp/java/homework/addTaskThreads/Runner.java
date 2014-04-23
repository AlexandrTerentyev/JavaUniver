package npp.java.homework.addTaskThreads;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Created by aleksandr on 17.04.14.
 */
public class Runner {
    public static void main(String args[]){
        File inFile = new File("/JavaUniver/src/main/java/npp/java/homework/addTaskThreads/input.txt");
        File outFile = new File("/JavaUniver/src/main/java/npp/java/homework/addTaskThreads/output.txt");
        try {

            PrintWriter printWriter = new PrintWriter(outFile.getAbsoluteFile());
            printWriter.print("print string");
            printWriter.close();




        } catch (Exception e) {
            e.printStackTrace();
        }
        MainThread myThread = new MainThread(inFile, outFile);
        myThread.calc();
    }
}
