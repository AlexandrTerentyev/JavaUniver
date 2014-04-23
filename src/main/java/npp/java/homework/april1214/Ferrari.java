package npp.java.homework.april1214;

/**
 * Created by aleksandr on 18.04.14.
 */
public class Ferrari extends Racecar {
    public Ferrari(int id, String color, int speed){
        super(id,color,speed);
    }

    @Override
    public void ride() {
        super.ride();
        System.out.print(" It's Ferrari.");
    }

    @Override
    public String toString() {
        return super.toString()+" I'm Ferrari";
    }
}
