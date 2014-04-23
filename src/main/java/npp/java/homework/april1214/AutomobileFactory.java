package npp.java.homework.april1214;

import java.util.Random;

/**
 * Created by aleksandr on 22.04.14.
 */
public class AutomobileFactory {
    public static Automobile createAutomobile (String automobileType){
        if (automobileType.equals("Ford")){
            Random rand = new Random();
            return new Ford (rand.nextInt(4)+1,"Black");
        }
        return null;
    }
}
