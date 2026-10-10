
import java.util.*;

abstract class TravelBooking {
    private static final double BOOKING_FEE = 50.0;
    double distance;

    TravelBooking(double distance) {
        this.distance = distance;
    }

    abstract double calculateBaseFare();

    final double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }

    abstract String getMode();
}

class BusBooking extends TravelBooking {
    BusBooking(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return distance * 2.0;
    }

    String getMode() {
        return "BUS";
    }
}

class TrainBooking extends TravelBooking {
    TrainBooking(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return distance * 1.5;
    }

    String getMode() {
        return "TRAIN";
    }
}

class FlightBooking extends TravelBooking {
    FlightBooking(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return 2500 + distance * 4.0;
    }

    String getMode() {
        return "FLIGHT";
    }
}

public class TravelBookingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            TravelBooking booking = switch (mode) {
                case "BUS" -> new BusBooking(distance);
                case "TRAIN" -> new TrainBooking(distance);
                case "FLIGHT" -> new FlightBooking(distance);
                default -> throw new IllegalArgumentException("Invalid mode");
            };

            System.out.printf("%s: %.2f%n",
                    booking.getMode(), booking.calculateTotal());
        }

        sc.close();
    }
}
