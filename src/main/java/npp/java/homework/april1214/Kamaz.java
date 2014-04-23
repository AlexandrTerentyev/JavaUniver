package npp.java.homework.april1214;

/**
 * Created by aleksandr on 18.04.14.
 */
public class Kamaz extends  Truck {
    Kamaz (int id, String color){
        super(id, color);
    }

    @Override
    public void ride() {
        super.ride();
        System.out.print(" Kamaz is cool");
    }

    @Override
    public String toString() {
        return super.toString()+ "I'm great Kamaz";
    }
}
