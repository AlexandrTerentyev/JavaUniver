package npp.java.homework.april1214;

/**
 * Created by aleksandr on 18.04.14.
 */
public class Racecar extends Car {
    private int speed;

    public Racecar(int id, String color, int speed){
        super(id, color);
        this.speed=speed;
    }

    void setSpeed(int speed){
        this.speed=speed;
    }

    int getSpeed(){
        return this.speed;
    }

    @Override
    public String toString() {
        return super.toString()+" I'm a Racecar, my speed: "+ speed +".";
    }

    @Override
    public void ride() {
        System.out.print("Ride this speed " + speed + ".");
    }
}
