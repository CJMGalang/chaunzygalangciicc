public class Task13 {

    public static void main(String [] args) {

        Car car = new Car("Jeep", "Wrangler", 2026, 4);
        System.out.print(car.displayDetails());
    }
}

abstract class Vehicle {
    String make;
    String model;
    int year;

    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }
}

class Car extends Vehicle{
    int numberOfDoors;

    public Car(String make, String model, int year, int numberOfDoors) {
        super(make, model, year);
        this.numberOfDoors = numberOfDoors;
    }

    public String displayDetails () {
        return  "Car Details: \n" +
                "Make: " + make + "\n" +
                "Model: " + model + "\n" +
                "Year: " + year + "\n" +
                "Number of Doors: " + numberOfDoors;
    }

}