package npp.java.homework.april1214;

import java.util.Random;

/**
 * Created by aleksandr on 22.04.14.
 */
public class TruckFactory {
    public static Truck createCar(String carType){
        if(carType.equals("Kamaz")){
            Random rand = new Random();
            return new Kamaz(rand.nextInt(4)+1, "Grey");
        }
        return null;
    }
}
