
import java.util.*;

abstract class Connection {
    int units;

    Connection(int units) {
        this.units = units;
    }

    abstract double calculateBill();

    abstract String getType();
}

class HomeConnection extends Connection {
    HomeConnection(int units) {
        super(units);
    }

    double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        }
        return 100 * 5.0 + (units - 100) * 7.0;
    }

    String getType() {
        return "HOME";
    }
}

class ShopConnection extends Connection {
    ShopConnection(int units) {
        super(units);
    }

    double calculateBill() {
        return units * 8.0 + 100;
    }

    String getType() {
        return "SHOP";
    }
}

class FactoryConnection extends Connection {
    FactoryConnection(int units) {
        super(units);
    }

    double calculateBill() {
        return Math.max(units * 6.0, 1000);
    }

    String getType() {
        return "FACTORY";
    }
}

public class ElectricityBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            Connection connection = switch (type) {
                case "HOME" -> new HomeConnection(units);
                case "SHOP" -> new ShopConnection(units);
                case "FACTORY" -> new FactoryConnection(units);
                default -> throw new IllegalArgumentException("Invalid type");
            };

            double bill = connection.calculateBill();
            System.out.printf("%s: %.2f%n", connection.getType(), bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
