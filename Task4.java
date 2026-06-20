import java.util.Scanner;

public class Task4 {

    void main () {

        //for statement will allow for multiple retries
        for (;;) {

            System.out.print("Enter a string: ");

            Scanner scanner = new Scanner(System.in);

            StringBuilder sb = new StringBuilder(scanner.next());

            //Statement to be used to determine if the input is a palindrome
            if (sb.toString().equalsIgnoreCase(sb.reverse().toString())) {
                System.out.println("The input string is a palindrome.");
            } else {
                System.out.println("The input string is not a palindrome.");
            }

            System.out.println();

        }
    }

}