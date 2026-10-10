
import java.util.Scanner;

public class WordReverserPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.next();
        StringBuilder reversed = new StringBuilder(word);
        reversed.reverse();

        String reverseWord = reversed.toString();

        System.out.println(reverseWord);

        if (word.equalsIgnoreCase(reverseWord)) {
            System.out.println("palindrome");
        } else {
            System.out.println("not a palindrome");
        }

        sc.close();
    }
}
