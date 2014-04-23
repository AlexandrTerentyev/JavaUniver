import java.io.FileNotFoundException;

/**
 * Created by aleksandr on 19.04.14.
 */
public class RunClass {
    public static void main (String[] args){
        try {
            SortingTool.sort("/Terentyev_Java/src/main/java/data.csv" , "/Terentyev_Java/src/main/java/output.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
