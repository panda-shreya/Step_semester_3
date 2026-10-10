
import java.util.*;

abstract class Payment {
    double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    abstract double calculate();

    String getType() {
        return getClass().getSimpleName().toUpperCase();
    }
}

class Card extends Payment {
    Card(double amount) { super(amount); }

    double calculate() {
        return amount * 1.02;
    }
}

class Wallet extends Payment {
    Wallet(double amount) { super(amount); }

    double calculate() {
        return amount * 1.01;
    }
}

class BankTransfer extends Payment {
    BankTransfer(double amount) { super(amount); }

    double calculate() {
        return amount;
    }

    String getType() {
        return "BANKTRANSFER";
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");
            String type = input[0];
            double amount = Double.parseDouble(input[1]);

            Payment payment = switch (type) {
                case "CARD" -> new Card(amount);
                case "WALLET" -> new Wallet(amount);
                case "BANKTRANSFER" -> new BankTransfer(amount);
                default -> throw new IllegalArgumentException("Invalid payment type");
            };

            double adjusted = payment.calculate();
            System.out.printf("%s: %.2f%n", payment.getType(), adjusted);
            total += adjusted;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
