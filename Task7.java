import java.util.Scanner;

public class Task7 {

    String x;
    String y;

    Double xNum;
    Double yNum;

    void main () {

        System.out.println();
        System.out.println("This code will compute the values you will input using all 4 basic arithmetic operations.");

        for (;;) {
            try {

                System.out.print("Please enter your first number: ");

                Scanner q1 = new Scanner(System.in);
                x = q1.next();

                if (x != null) {

                    xNum = Double.parseDouble(x);

                    System.out.println();
                    System.out.print("Please enter your second number: ");

                    Scanner q2 = new Scanner(System.in);
                    y = q2.next();

                    if (y != null) {

                        yNum = Double.parseDouble(y);

                        System.out.println();
                        System.out.println("ANSWERS");
                        System.out.println(xNum + " + " + yNum + " = " + Add(xNum, yNum));
                        System.out.println(xNum + " - " + yNum + " = " + Sub(xNum, yNum));
                        System.out.println(xNum + " * " + yNum + " = " + Mul(xNum, yNum));
                        System.out.println(xNum + " / " + yNum + " = " + Div(xNum, yNum));

                    }
                }
            } catch (Exception e) {
                System.out.println();
                System.out.println("Invalid input: " + e);
            } finally {
                System.out.println();
                System.out.println("Feel free to try again.");
                System.out.println();
            }
        }
    }

    //Below are the methods used to perform the 4 basic arithmetic operations.

    double Add (double xNum, double yNum) {
        return xNum + yNum;
    }

    double Sub (double xNum, double yNum) {
        return xNum - yNum;
    }

    double Mul (double xNum, double yNum) {
        return xNum * yNum;
    }

    double Div (double xNum, double yNum) {
        return xNum / yNum;
    }

}