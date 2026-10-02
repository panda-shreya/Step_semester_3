import java.util.Scanner;

public class Top3PodiumFinder {

    static void findTop3(int[] scores) {

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int score : scores) {

            if (score > first) {
                third = second;
                second = first;
                first = score;
            } 
            else if (score > second && score != first) {
                third = second;
                second = score;
            } 
            else if (score > third && score != second && score != first) {
                third = score;
            }
        }

        System.out.println("1st Place: " + first);
        System.out.println("2nd Place: " + second);
        System.out.println("3rd Place: " + third);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of teams: ");
        int n = sc.nextInt();

        int[] scores = new int[n];

        System.out.println("Enter scores:");

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        findTop3(scores);

        sc.close();
    }
}