package Task;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList cars = setListCar();

        System.out.println(cars);
        cars.remove(0);
        cars.remove(0);
        System.out.println(cars);

    }

    public static ArrayList setListCar(){
        ArrayList<String> cars = new ArrayList<>();
        cars.add("BMW M1");
        cars.add("BMW M2");
        cars.add("BMW M3");
        cars.add("BMW M4");
        cars.add("BMW M5");
        cars.add("BMW M6");
        cars.add("BMW 760M");
        cars.add("BMW M8");
        cars.add("BMW I4");
        cars.add("BMW I8");
        return cars;
    }

}