package npp.java.homework.addTaskThreads;

import java.io.*;

/**
 * Created by aleksandr on 16.04.14.
 */
public class MainThread {

    private String currentString;
    private int currentResult;
    private File inputFile;
    private File outputFile;



    private Boolean nextStingIsRead;
    private Boolean currentStringIsCalculated;
    private Boolean currentResultIsWrote;
    private Boolean endOfFile;
    private Boolean resultReadyToBeWrote;

    private Boolean firstIteration;

    public MainThread(File inFile, File outFile){
        inputFile=inFile;
        outputFile=outFile;

    }

    public void calc (){
        nextStingIsRead=false;
        currentStringIsCalculated=false;
        currentResultIsWrote=true;
        endOfFile=false;
        resultReadyToBeWrote=false;
        firstIteration=true;



        ReadingThread readThread = new ReadingThread();
        CalculatingThread calcThread = new CalculatingThread();
        WritingThread writeThread = new WritingThread();
        readThread.start();
        calcThread.start();
        writeThread.start();
    }





    public class ReadingThread extends Thread{




        @Override
        public void run(){
            FileReader fReader;
            BufferedReader bufReader;
            String tempString = "";
            try {
                fReader = new FileReader(inputFile);
                bufReader = new BufferedReader(fReader);
                while (!(endOfFile=((tempString=bufReader.readLine())==null))){

                    //wait for current string is calculated
                    if (!firstIteration)
                    while (!currentStringIsCalculated){
                        yield();
                    }
                    else{
                        firstIteration=false;
                    }

                    nextStingIsRead=false;

                    //save new string
                    currentString=tempString;
                    tempString="";
                    nextStingIsRead=true;
                    yield();
                }


            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public class CalculatingThread extends Thread{
        @Override
        public void run(){

            while (!endOfFile) {


                //wait for nextString reading
                while (!nextStingIsRead) {
                    yield();
                }

                //calculate current string

                currentStringIsCalculated=false;
                int tempResult = 0;
                for (int i = 0; i < currentString.length(); i++) {
                    char c = currentString.toCharArray()[i];
                    if (c != ' ') {
                        tempResult += c - '0';
                    }

                }

                currentStringIsCalculated=true;

                //wait for prev result is wrote
                while (!currentResultIsWrote) {
                    yield();
                }

                resultReadyToBeWrote=false;
                currentResult = tempResult;

                resultReadyToBeWrote=true;
                yield();

            }

        }
    }

    public class WritingThread extends Thread{
        @Override
        public void run() {
            while (!endOfFile) {
                while (!resultReadyToBeWrote){
                    yield();
                }


                try {
                     currentResultIsWrote=false;

                     PrintWriter fileWriter = new PrintWriter(outputFile.getAbsoluteFile());
                     /*BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                     bufferedWriter.write(currentResult);
                     bufferedWriter.newLine();*/
                     fileWriter.print(currentResult+"\n");
                     fileWriter.close();

                     currentResultIsWrote=true;

                    }
                catch (Exception e) {
                        e.printStackTrace();
                    }

            }
        }
    }


}
