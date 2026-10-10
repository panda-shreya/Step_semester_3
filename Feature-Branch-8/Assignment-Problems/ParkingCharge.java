
import java.util.*;

abstract class Vehicle {
    int hours;

    Vehicle(int hours) {
        this.hours = hours;
    }

    abstract double calculateCharge();
    abstract String getType();
}

class Bike extends Vehicle {
    Bike(int hours) { super(hours); }

    double calculateCharge() { return 10.0 * hours; }
    String getType() { return "BIKE"; }
}

class Car extends Vehicle {
    Car(int hours) { super(hours); }

    double calculateCharge() {
        return 30 + 20.0 * (hours - 1);
    }

    String getType() { return "CAR"; }
}

class Truck extends Vehicle {
    Truck(int hours) { super(hours); }

    double calculateCharge() {
        return Math.max(100, 50.0 * hours);
    }

    String getType() { return "TRUCK"; }
}

public class ParkingCharge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();

            Vehicle vehicle = switch (type) {
                case "BIKE" -> new Bike(hours);
                case "CAR" -> new Car(hours);
                case "TRUCK" -> new Truck(hours);
                default -> throw new IllegalArgumentException("Invalid vehicle type");
            };

            double charge = vehicle.calculateCharge();
            System.out.printf("%s: %.2f%n", vehicle.getType(), charge);
            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
