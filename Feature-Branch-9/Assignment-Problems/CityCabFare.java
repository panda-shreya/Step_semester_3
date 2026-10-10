
import java.util.*;

interface NightService {
    double applyNightCharge(double fare);
}

abstract class Cab {
    private static final double MINIMUM_FARE = 100.0;
    double distance;

    Cab(double distance) {
        this.distance = distance;
    }

    abstract double getRate();

    abstract String getType();

    final double calculateFare(boolean night) {
        double fare = Math.max(MINIMUM_FARE, distance * getRate());

        if (night) {
            if (!(this instanceof NightService)) {
                return -1;
            }
            fare = ((NightService) this).applyNightCharge(fare);
        }

        return fare;
    }
}

class MiniCab extends Cab {
    MiniCab(double distance) {
        super(distance);
    }

    double getRate() {
        return 10.0;
    }

    String getType() {
        return "MINI";
    }
}

class SedanCab extends Cab implements NightService {
    SedanCab(double distance) {
        super(distance);
    }

    double getRate() {
        return 14.0;
    }

    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }

    String getType() {
        return "SEDAN";
    }
}

class SUVCab extends Cab implements NightService {
    SUVCab(double distance) {
        super(distance);
    }

    double getRate() {
        return 18.0;
    }

    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }

    String getType() {
        return "SUV";
    }
}

public class CityCabFare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab = switch (type) {
                case "MINI" -> new MiniCab(km);
                case "SEDAN" -> new SedanCab(km);
                case "SUV" -> new SUVCab(km);
                default -> throw new IllegalArgumentException("Invalid cab type");
            };

            boolean night = time.equals("NIGHT");
            double fare = cab.calculateFare(night);

            if (fare < 0) {
                System.out.printf("%s: night service not available%n", type);
            } else {
                System.out.printf("%s: %.2f%n", type, fare);
                total += fare;
            }
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
