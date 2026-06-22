import java.util.Scanner;

public class Task9 {

    public static void main (String[] args) {

        int x;
        int y;

        for (;;) {

            try {

                Scanner q = new Scanner(System.in);

                System.out.print("1st Number: ");
                x = q.nextInt();
                System.out.println();

                System.out.print("2nd Number: ");
                y = q.nextInt();
                System.out.println();

                System.out.print("Choose an arithmetic operation by typing one of the following:");
                System.out.println("\n + \n - \n * \n /");
                System.out.print("Enter the symbol here: ");
                final String symbol = q.next();

                switch (symbol) {
                    case "+":
                        System.out.println("Answer: " + add(x, y));
                        break;

                    case "-":
                        System.out.println("Answer: " + subtract(x, y));
                        break;

                    case "*":
                        System.out.println("Answer: " + multiply(x, y));
                        break;

                    case "/":
                        System.out.println("Answer: " + divide(x, y));
                        break;

                    default:
                        System.out.println();
                        System.out.println("Invalid operation.");
                        break;
                }

            } catch (Exception e) {
                System.out.println();
                System.out.println("Invalid input: " + e);
            } finally {
                System.out.println("Feel free to try again.");
                System.out.println();
            }
        }
    }

    public static int add (int a, int b) {
        return Math.addExact(a, b);
    }

    public static int subtract (int a, int b) {
        return Math.subtractExact(a, b);
    }

    public static int multiply (int a, int b) {
        return Math.multiplyExact(a, b);
    }

    public static float divide (int a, int b) {
        return Math.floorDiv(a, b);
    }

}
