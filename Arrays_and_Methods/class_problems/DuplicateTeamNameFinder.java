import java.util.Scanner;

public class DuplicateTeamNameFinder {

    static boolean hasDuplicate(String[] teams) {

        for (int i = 0; i < teams.length; i++) {
            for (int j = i + 1; j < teams.length; j++) {

                if (teams[i].equalsIgnoreCase(teams[j])) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of teams: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] teams = new String[n];

        System.out.println("Enter team names:");

        for (int i = 0; i < n; i++) {
            teams[i] = sc.nextLine();
        }

        if (hasDuplicate(teams)) {
            System.out.println("Duplicate team name found.");
        } else {
            System.out.println("No duplicate team names.");
        }

        sc.close();
    }
}