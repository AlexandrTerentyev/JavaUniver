package npp.java.homework.april1214;

/**
 * Created by aleksandr on 18.04.14.
 */
public class Automobile extends Car {

    @Override
    public void ride() {
        System.out.print("Automobile rides");
    }

    public Automobile(int id, String color){
        super(id,color);
    }

    @Override
    public String toString() {
        return super.toString()+" I'm automobile.";
    }
}
