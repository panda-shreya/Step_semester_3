
import java.util.*;

interface SaverMode {
    double getSaverUnits(double normalUnits);
}

abstract class Appliance {
    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    abstract String getType();

    double calculateUnits() {
        return getPower() * hours / 1000.0;
    }

    final double calculateCost(double units) {
        return units * 8.0;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150.0;
    }

    String getType() {
        return "FRIDGE";
    }
}

class AC extends Appliance implements SaverMode {
    AC(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500.0;
    }

    String getType() {
        return "AC";
    }

    public double getSaverUnits(double units) {
        return units * 0.75;
    }
}

class TV extends Appliance {
    TV(double hours) {
        super(hours);
    }

    double getPower() {
        return 100.0;
    }

    String getType() {
        return "TV";
    }
}

class Washer extends Appliance implements SaverMode {
    Washer(double hours) {
        super(hours);
    }

    double getPower() {
        return 500.0;
    }

    String getType() {
        return "WASHER";
    }

    public double getSaverUnits(double units) {
        return units * 0.75;
    }
}

public class ApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");
            String type = input[0];
            double hours = Double.parseDouble(input[1]);
            boolean saver = input.length > 2 && input[2].equals("SAVER");

            Appliance appliance = switch (type) {
                case "FRIDGE" -> new Fridge(hours);
                case "AC" -> new AC(hours);
                case "TV" -> new TV(hours);
                case "WASHER" -> new Washer(hours);
                default -> throw new IllegalArgumentException("Invalid appliance");
            };

            if (saver && !(appliance instanceof SaverMode)) {
                System.out.printf("%s: saver mode not supported%n", type);
                continue;
            }

            double units = appliance.calculateUnits();

            if (saver) {
                units = ((SaverMode) appliance).getSaverUnits(units);
            }

            double cost = appliance.calculateCost(units);

            System.out.printf("%s: Units=%.2f Cost=%.2f%n",
                    appliance.getType(), units, cost);

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
