package npp.java.classwork.sorter;

/**
 * Created by aleksandr on 19.04.14.
 */
public class Human implements Comparable {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age>=0 && age<=100) {
            this.age = age;
        }
        else{
            //TODO:exception
        }
    }

    public Human (String name, int age){
        if (age>=0 && age<=100) {
            this.name = name;
            this.age = age;
        }
        else {
            //TODO: age exception
        }
    }

    @Override
    public String toString() {
        return this.getName()+"\t"+this.getAge()+"\n";
    }

    @Override
    public int compareTo(Object o) {
        Human second = (Human) o;
        int result=this.name.compareTo(second.name);
        return result;
    }
}
