
import java.util.*;

abstract class Customer {
    double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    abstract double calculateAmount();
    abstract String getType();
}

class Student extends Customer {
    Student(double amount) { super(amount); }

    double calculateAmount() { return amount * 0.90; }
    String getType() { return "STUDENT"; }
}

class Staff extends Customer {
    Staff(double amount) { super(amount); }

    double calculateAmount() { return amount * 0.95; }
    String getType() { return "STAFF"; }
}

class Guest extends Customer {
    Guest(double amount) { super(amount); }

    double calculateAmount() { return amount + 10; }
    String getType() { return "GUEST"; }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            Customer customer = switch (type) {
                case "STUDENT" -> new Student(amount);
                case "STAFF" -> new Staff(amount);
                case "GUEST" -> new Guest(amount);
                default -> throw new IllegalArgumentException("Invalid customer type");
            };

            double bill = customer.calculateAmount();
            System.out.printf("%s: %.2f%n", customer.getType(), bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
