public class TaskThree {

    //Corrected variables
    String a = "Wow";
    String b = "Wow";
    String c = a.substring(1);
    String d = b + "!";

    //Given variables
    boolean b1 = a == b;
    boolean b2 = d.equals(b + "!");
    boolean b3 = !c.equals(a);

    void main () {

        if (b1 && b2 && b3) {
            System.out.println("Success!");
        }

    }
}
