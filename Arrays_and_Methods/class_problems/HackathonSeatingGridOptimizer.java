import java.util.Scanner;

public class HackathonSeatingGridOptimizer {

    static int findMaximum(int[][] grid) {

        int max = grid[0][0];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
        }

        return max;
    }

    static int findMinimum(int[][] grid) {

        int min = grid[0][0];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] < min) {
                    min = grid[i][j];
                }
            }
        }

        return min;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        int[][] grid = new int[rows][];

        for (int i = 0; i < rows; i++) {

            System.out.print("Enter number of seats in row " + (i + 1) + ": ");
            int columns = sc.nextInt();

            grid[i] = new int[columns];

            System.out.println("Enter seat values:");

            for (int j = 0; j < columns; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println("Maximum value: " + findMaximum(grid));
        System.out.println("Minimum value: " + findMinimum(grid));

        sc.close();
    }
}