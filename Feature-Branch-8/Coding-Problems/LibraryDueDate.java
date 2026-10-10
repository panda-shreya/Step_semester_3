
import java.time.LocalDate;
import java.util.*;
import java.util.regex.*;

abstract class LibraryItem {
    String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int borrowingDays();

    LocalDate getDueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(borrowingDays());
    }
}

class Book extends LibraryItem {
    Book(String title) { super(title); }
    int borrowingDays() { return 14; }
}

class DVD extends LibraryItem {
    DVD(String title) { super(title); }
    int borrowingDays() { return 7; }
}

class Magazine extends LibraryItem {
    Magazine(String title) { super(title); }
    int borrowingDays() { return 3; }
}

public class LibraryDueDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Pattern pattern = Pattern.compile("\"([^\"]*)\"");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String type = line.split("\\s+", 2)[0];

            Matcher matcher = pattern.matcher(line);
            if (!matcher.find()) {
                throw new IllegalArgumentException("Title must be quoted");
            }
            String title = matcher.group(1);

            LibraryItem item = switch (type) {
                case "BOOK" -> new Book(title);
                case "DVD" -> new DVD(title);
                case "MAGAZINE" -> new Magazine(title);
                default -> throw new IllegalArgumentException("Invalid item type");
            };

            System.out.println(title + ": " + item.getDueDate());
        }

        sc.close();
    }
}
