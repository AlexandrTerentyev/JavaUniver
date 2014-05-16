package npp.java.homework.april2614.findWord;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by aleksandr on 16.05.14.
 */
public class Finder {
    /**
     * <p>find all numbers of positions of first letter of key word</p>
     * @param reader file buffered reader
     * @param word word to be found
     * @return list of number positions (positions of first letter of the key word)
     * @throws IOException
     */
    public static LinkedList<Integer> findPositions (BufferedReader reader, char[] word) throws IOException {
        LinkedList<Integer> result = new LinkedList<Integer>();

        String s = reader.readLine();
        int beginOfString = 0;
        while (s!=null){
            char[] string = s.toCharArray();
            int firstChar;
            for (int i=0; i<string.length; i++){
                if (string[i]==word[0]){//same first letter
                    int j=0;
                    firstChar=i;
                    while (j<word.length &&  i!=string.length && string[i]==word[j] ){ //while letters are identical
                        i++;
                        j++;
                    }
                    if (j==word.length){//find word
                        result.add(firstChar+beginOfString);//add to list position
                    }
                }
            }
            beginOfString+=string.length;//index of begin of next string
            s=reader.readLine();//read next string
        }
        return result;
    }

    /**
     * <p>find all positions in text (all numbers of word to be find)</p>
     * @param reader file buffered reader
     * @param word word to find all of positions (by number of words in text)
     * @return list of positions
     * @throws IOException
     */
    public static LinkedList<Integer> findWordNumbers (BufferedReader reader, String word) throws IOException {
        LinkedList<Integer> result = new LinkedList<Integer>();
        String s = reader.readLine();
        int wordsCount=0;
        while (s!=null){
            StringTokenizer stringTokenizer = new StringTokenizer(s," \t\r,:-().!?;",false);//parse current string
            String currentWord = stringTokenizer.nextToken();//next word from current string
            while (stringTokenizer.hasMoreTokens()){
                wordsCount++;
                if (currentWord.equals(word)){//identical word
                    result.add(wordsCount);
                }
                currentWord = stringTokenizer.nextToken();
            }
            s=reader.readLine();//read next string
        }
        return result;
    }
}
