
import java.util.*;

interface BusUser {
    double getTransportFee();
}

abstract class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateTuition();

    abstract double calculateOtherFees();

    final double calculateTotalFee() {
        return calculateTuition() + calculateOtherFees();
    }
}

class DayScholar extends Student implements BusUser {
    DayScholar(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000;
    }

    double calculateOtherFees() {
        return getTransportFee();
    }

    public double getTransportFee() {
        return 12000;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000;
    }

    double calculateOtherFees() {
        return 60000;
    }
}

class Scholar extends Student implements BusUser {
    Scholar(String name) {
        super(name);
    }

    double calculateTuition() {
        return 20000;
    }

    double calculateOtherFees() {
        return getTransportFee();
    }

    public double getTransportFee() {
        return 12000;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Student student = switch (type) {
                case "DAY_SCHOLAR" -> new DayScholar(name);
                case "HOSTELLER" -> new Hosteller(name);
                case "SCHOLAR" -> new Scholar(name);
                default -> throw new IllegalArgumentException("Invalid student type");
            };

            double fee = student.calculateTotalFee();
            System.out.printf("%s: %.2f%n", student.name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}
