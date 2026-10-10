
import java.time.LocalDate;
import java.util.*;

abstract class SubscriptionPlan {
    String name;
    LocalDate startDate;

    SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int validityDays();

    LocalDate getRenewalDate() {
        return startDate.plusDays(validityDays());
    }
}

class BasicPlan extends SubscriptionPlan {
    BasicPlan(String name, LocalDate date) { super(name, date); }
    int validityDays() { return 30; }
}

class StandardPlan extends SubscriptionPlan {
    StandardPlan(String name, LocalDate date) { super(name, date); }
    int validityDays() { return 90; }
}

class PremiumPlan extends SubscriptionPlan {
    PremiumPlan(String name, LocalDate date) { super(name, date); }
    int validityDays() { return 365; }
}

public class StreamingRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");
            String type = input[0];
            String name = input[1];
            LocalDate date = LocalDate.parse(input[2]);

            SubscriptionPlan plan = switch (type) {
                case "BASIC" -> new BasicPlan(name, date);
                case "STANDARD" -> new StandardPlan(name, date);
                case "PREMIUM" -> new PremiumPlan(name, date);
                default -> throw new IllegalArgumentException("Invalid plan type");
            };

            System.out.println(plan.name + ": " + plan.getRenewalDate());
        }

        sc.close();
    }
}
