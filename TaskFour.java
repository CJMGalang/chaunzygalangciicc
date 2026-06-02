import java.util.Scanner;

public class TaskFour {

    void main () {

        for (;;) {

            System.out.print("Enter a string: ");

            Scanner scanner = new Scanner(System.in);

            StringBuilder sb = new StringBuilder(scanner.next());

            if (sb.toString().equalsIgnoreCase(sb.reverse().toString())) {
                System.out.println("The input string is a palindrome.");
            } else {
                System.out.println("The input string is not a palindrome.");
            }

        }
    }

}