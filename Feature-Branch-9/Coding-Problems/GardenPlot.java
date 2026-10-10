
import java.util.*;

abstract class Plot {
    String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double calculateArea();

    abstract String getShape();
}

class CirclePlot extends Plot {
    double radius;

    CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }

    String getShape() {
        return "CIRCLE";
    }
}

class RectanglePlot extends Plot {
    double length, width;

    RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    double calculateArea() {
        return length * width;
    }

    String getShape() {
        return "RECTANGLE";
    }
}

class TrianglePlot extends Plot {
    double base, height;

    TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    double calculateArea() {
        return 0.5 * base * height;
    }

    String getShape() {
        return "TRIANGLE";
    }
}

public class GardenPlot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();

            Plot plot = switch (shape) {
                case "CIRCLE" -> new CirclePlot(owner, sc.nextDouble());
                case "RECTANGLE" -> new RectanglePlot(
                    owner, sc.nextDouble(), sc.nextDouble()
                );
                case "TRIANGLE" -> new TrianglePlot(
                    owner, sc.nextDouble(), sc.nextDouble()
                );
                default -> throw new IllegalArgumentException("Invalid shape");
            };

            double area = plot.calculateArea();
            System.out.printf("%s (%s): %.2f%n",
                              plot.owner, plot.getShape(), area);
            total += area;
        }

        System.out.printf("Total Area: %.2f%n", total);
        sc.close();
    }
}
