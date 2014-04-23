package npp.java.homework.april1214;

import java.util.Scanner;

/**
 * Created by aleksandr on 23.04.14.
 */
public class SalonTester {
    public static void main(String []args){
        AutoSalon autoSalon = new AutoSalon();
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        autoSalon.printCars(autoSalon.findCarsById(id));
    }

}
