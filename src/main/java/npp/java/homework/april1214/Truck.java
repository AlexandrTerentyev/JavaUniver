package npp.java.homework.april1214;

/**
 * Created by aleksandr on 18.04.14.
 */
public class Truck extends Car {
    @Override
    public void ride() {
        System.out.print("I'm truck. I ride");
    }

    public Truck(int id, String color){
        super(id,color);
    }

    @Override
    public String toString() {
        return super.toString()+"I'm truck.";
    }
}
