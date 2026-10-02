import java.util.Scanner;

public class HackathonScoreCurveBooster {

    static void boostScores(int[] scores) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] = Math.min(scores[i] + 10, 100);
        }
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

        boostScores(scores);

        System.out.println("Boosted scores:");
        for (int score : scores) {
            System.out.print(score + " ");
        }

        sc.close();
    }
}