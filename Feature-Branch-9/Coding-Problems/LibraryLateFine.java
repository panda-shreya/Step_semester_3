
import java.util.*;

abstract class LibraryItem {
    String title;
    int daysLate;

    LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double calculateFine();
}

class BookItem extends LibraryItem {
    BookItem(String title, int days) {
        super(title, days);
    }

    double calculateFine() {
        return daysLate * 2.0;
    }
}

class DVDItem extends LibraryItem {
    DVDItem(String title, int days) {
        super(title, days);
    }

    double calculateFine() {
        return Math.min(daysLate * 5.0, 50.0);
    }
}

class MagazineItem extends LibraryItem {
    MagazineItem(String title, int days) {
        super(title, days);
    }

    double calculateFine() {
        return daysLate;
    }
}

public class LibraryLateFine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int days = sc.nextInt();

            LibraryItem item = switch (type) {
                case "BOOK" -> new BookItem(title, days);
                case "DVD" -> new DVDItem(title, days);
                case "MAGAZINE" -> new MagazineItem(title, days);
                default -> throw new IllegalArgumentException("Invalid item type");
            };

            double fine = item.calculateFine();
            System.out.printf("%s: %.2f%n", item.title, fine);
            total += fine;
        }

        System.out.printf("Total Fines: %.2f%n", total);
        sc.close();
    }
}
