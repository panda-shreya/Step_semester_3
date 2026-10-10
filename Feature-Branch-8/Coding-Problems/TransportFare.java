
import java.util.*;

abstract class Transport {
    double distance;

    Transport(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();
    abstract String getType();
}

class Bus extends Transport {
    Bus(double d) { super(d); }

    double calculateFare() {
        return Math.min(10, 2 + 0.10 * distance);
    }

    String getType() { return "BUS"; }
}

class Train extends Transport {
    Train(double d) { super(d); }

    double calculateFare() {
        return 3 + 0.15 * distance;
    }

    String getType() { return "TRAIN"; }
}

class Metro extends Transport {
    double peakFactor;

    Metro(double d, double factor) {
        super(d);
        peakFactor = factor;
    }

    double calculateFare() {
        return (1.50 + 0.20 * distance) * peakFactor;
    }

    String getType() { return "METRO"; }
}

public class TransportFare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            Transport transport = switch (type) {
                case "BUS" -> new Bus(distance);
                case "TRAIN" -> new Train(distance);
                case "METRO" -> new Metro(distance, sc.nextDouble());
                default -> throw new IllegalArgumentException("Invalid transport type");
            };

            double fare = transport.calculateFare();
            System.out.printf("%s: %.2f%n", transport.getType(), fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
