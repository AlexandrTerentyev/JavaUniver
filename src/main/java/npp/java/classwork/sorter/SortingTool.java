package npp.java.classwork.sorter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by aleksandr on 19.04.14.
 */
public class SortingTool {
    public static void sort(String inputFilePath, String outputFilePath) throws FileNotFoundException {
        final HumanLinkedList [] lists = new HumanLinkedList[100];


        for (int i=0; i<100;i++){
            lists[i]=new HumanLinkedList();
        }
        File inputFile = new File(inputFilePath);
        File outputFile = new File(outputFilePath);
        Scanner scanner =  new Scanner(inputFile);

        while (scanner.hasNext()){//while not the end of file
            scanner.useDelimiter("\t");
            String name = scanner.next();

            scanner.skip("\t");

            scanner.useDelimiter("\n");



            int age = scanner.nextInt();

            scanner.skip("\n");

            Human human = new Human(name, age);

            lists[age].add(human);

            //sortByName by name


            }

        Runnable r[] = new Runnable[100];
        Thread threads [] =new Thread[100];

        for (int i=0; i<100; i++) {
            final int currentAge = i;
            r[i] = new Runnable() {
                @Override
                public void run() {
                    lists[currentAge].sortByName();
                    synchronized (this) {
                        notifyAll();
                    }
                }
            };
            threads[i] = new Thread(r[i]);
            threads[i].start();
        }


        //wait for ending of all threads
        for (int i=0; i<100; i++){
            Thread nextThread = threads[i];
            if (nextThread.isAlive()){
                try {
                    synchronized (nextThread) {
                        nextThread.wait();
                    }
                } catch (InterruptedException e) {
                    // do nothing
                }
            }
        }

        HumanLinkedList result = lists[0];

        for (int i=1; i<100; i++){
            result.append(lists[i]);
        }

        PrintWriter printToOutputFile = new PrintWriter(outputFile);

        while (!result.endOfList()){
            printToOutputFile.print(result.getCurrent());
        }

        scanner.close();

        printToOutputFile.close();


    }
}
