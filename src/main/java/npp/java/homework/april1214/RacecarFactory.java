package npp.java.homework.april1214;

import java.util.Random;

/**
 * Created by aleksandr on 22.04.14.
 */
public class RacecarFactory {

    public static Racecar createCar (String carType){
        if (carType.equals("Ferrari")){
            Random rand = new Random();
            return new Ferrari (rand.nextInt(4)+1,"Red",200);
        }
        if (carType.equals("Lamborgini")){
            Random rand = new Random();
            return new Lamborgini(rand.nextInt(4)+1,"Yellow",220);
        }
        return null;
    }
}

