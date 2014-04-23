package npp.java.homework.april1214;

/**
 * Created by aleksandr on 18.04.14.
 */
public class Lamborgini extends Racecar {
    Lamborgini(int id, String color, int speed){
        super(id,color, speed);
    }

    @Override
    public void ride() {
        super.ride();
        System.out.print("Lambo.");
    }

    @Override
    public String toString() {
        return super.toString()+"I'm Lamborgini";
    }
}
