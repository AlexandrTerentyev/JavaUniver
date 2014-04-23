package npp.java.homework.april1214;

import java.util.ArrayList;

/**
 * Created by aleksandr on 22.04.14.
 */
public class AutoSalon {
    ArrayList<Car> lamboList;
    ArrayList<Car> ferrariList;
    ArrayList<Car> kamazArrayList;
    ArrayList<Car> fordList;


    public AutoSalon(){

        int listsLength = 8;

        lamboList= new ArrayList<Car>(listsLength);
        ferrariList= new ArrayList<Car>(listsLength);
        kamazArrayList= new ArrayList<Car>(listsLength);
        fordList= new ArrayList<Car>(listsLength);

        for (int i=0; i<listsLength; i++){
            lamboList.add(RacecarFactory.createCar("Lamborgini"));
            ferrariList.add(RacecarFactory.createCar("Ferrari"));
            kamazArrayList.add(TruckFactory.createCar("Kamaz"));
            fordList.add(AutomobileFactory.createAutomobile("Ford"));
        }

    }

    public ArrayList<Car> findCarsById(final int id){
        final ArrayList<Car> result = new ArrayList<Car>();

        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<lamboList.size();i++){
                    if ((lamboList.get(i).getId())==id){
                        synchronized (result){
                            result.add(lamboList.get(i));
                        }
                    }
                }
            }
        };

        Runnable run2 = new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<ferrariList.size();i++){
                    if ((ferrariList.get(i).getId())==id){
                        synchronized (result){
                            result.add(ferrariList.get(i));
                        }
                    }
                }
            }
        };

        Runnable run3 = new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<kamazArrayList.size();i++){
                    if ((kamazArrayList.get(i).getId())==id){
                        synchronized (result){
                            result.add(kamazArrayList.get(i));
                        }
                    }
                }
            }
        };

        Runnable run4 = new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<fordList.size();i++){
                    if ((fordList.get(i).getId())==id){
                        synchronized (result){
                            result.add(fordList.get(i));
                        }
                    }
                }
            }
        };

        Thread thread1 = new Thread(run1);
        Thread thread2 = new Thread(run2);
        Thread thread3 = new Thread(run3);
        Thread thread4 = new Thread (run4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        return result;
    }


    public void printCars(ArrayList<Car> list){
        for (int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+"\n");
        }
    }


}
