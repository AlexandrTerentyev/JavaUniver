package npp.java.homework.april1214;

/**
 * Created by aleksandr on 18.04.14.
 */
public abstract class Car implements Rideable {
    private int id;
    private String color;

    public Car(int id, String color){
        this.color=color;
        this.id=id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setColor(String color){
        this.color=color;
    }

    public String getColor(){
        return this.color;
    }

    @Override
    public String toString() {
        return "I'm a car. My ID is "+id+", my color is "+color+".";
    }

}
