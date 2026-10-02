import java.util.Scanner;

public class PlacementShortlistingRanking {

    static void sortDescending(int[] scores) {

        for (int i = 0; i < scores.length - 1; i++) {

            for (int j = i + 1; j < scores.length; j++) {

                if (scores[j] > scores[i]) {

                    int temp = scores[i];
                    scores[i] = scores[j];
                    scores[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();

        int[] scores = new int[n];

        System.out.println("Enter candidate scores:");

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        sortDescending(scores);

        System.out.println("Candidates ranked by score:");

        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + ". " + scores[i]);
        }

        sc.close();
    }
}