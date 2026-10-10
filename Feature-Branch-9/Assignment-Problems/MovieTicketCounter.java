
import java.util.*;

abstract class Ticket {
    private static final double CONVENIENCE_FEE = 20.0;
    int count;

    Ticket(int count) {
        this.count = count;
    }

    abstract double getPricePerTicket();

    abstract String getSeatType();

    final double calculateAmount() {
        return count * (getPricePerTicket() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {
    RegularTicket(int count) {
        super(count);
    }

    double getPricePerTicket() {
        return 150.0;
    }

    String getSeatType() {
        return "REGULAR";
    }
}

class PremiumTicket extends Ticket {
    PremiumTicket(int count) {
        super(count);
    }

    double getPricePerTicket() {
        return 250.0;
    }

    String getSeatType() {
        return "PREMIUM";
    }
}

class ReclinerTicket extends Ticket {
    ReclinerTicket(int count) {
        super(count);
    }

    double getPricePerTicket() {
        return 400.0;
    }

    String getSeatType() {
        return "RECLINER";
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();

            Ticket ticket = switch (seat) {
                case "REGULAR" -> new RegularTicket(count);
                case "PREMIUM" -> new PremiumTicket(count);
                case "RECLINER" -> new ReclinerTicket(count);
                default -> throw new IllegalArgumentException("Invalid seat type");
            };

            double amount = ticket.calculateAmount();
            System.out.printf("%s: %.2f%n", ticket.getSeatType(), amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
