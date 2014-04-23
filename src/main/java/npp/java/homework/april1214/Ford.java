package npp.java.homework.april1214;

/**
 * Created by aleksandr on 18.04.14.
 */
public class Ford extends Automobile {
    Ford(int id, String color){
        super(id, color);
    }

    @Override
    public void ride() {
        super.ride();
        System.out.print("Ford rides. ");
    }

    @Override
    public String toString() {
        return super.toString()+" I'm Ford";
    }
}
