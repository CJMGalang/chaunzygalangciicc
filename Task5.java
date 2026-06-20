import java.util.Scanner;

public class Task5 {
    void main () {

    System.out.print("First number: ");

    //for statement will allow for multiple retries
    for (;;) {

        //Input for the 1st number
        Scanner s1 = new Scanner(System.in);
        String x = s1.next();

        try {

            if (x != null) {

                //String to double
                double xNum = Double.parseDouble(x);

                System.out.print("Second number: ");

                //Input for 2nd number
                Scanner s2 = new Scanner(System.in);
                String y = s2.next();

                if (y != null) {

                    //String to double
                    double yNum = Double.parseDouble(y);

                    System.out.print("Third number: ");

                    //Input for 3rd number
                    Scanner s3 = new Scanner(System.in);
                    String z = s3.next();

                    if (z != null) {
                        
                        //String to double
                        double zNum = Double.parseDouble(z);

                        double[] list = {xNum, yNum, zNum};
                        double max = list[0];

                        //Comparison of inputs
                        if (max == list[1] & max == list[2]) {
                            System.out.println("They are all equal.");
                        } else {

                            for (int i = 1; i <= 2; i++) {

                                if (list[i] > max) {
                                    max = list[i];
                                }
                            }

                            System.out.println("The largest number is: " + max); //Display the largest number

                        }
                    }
                }

            }
        } catch (Exception Exc) {    
            
            //Displays an error for invalid inputs
            System.out.println("Invalid input! Please try again. (" + Exc + ")");

        } finally {

            System.out.println();
            System.out.print("First number: ");
            
        }
    }
    }
}
