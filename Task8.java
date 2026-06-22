public class Task8 {

    /* This program outputs a value depending on the arguments in LINE 9.
     * Accepted arguments include both positive and negative whole numbers.
     */

    public static void main (String[] args) {
        //Edit your arguments here:
        System.out.println(varargsMethod(4, 5, 10));
    }

    static long varargsMethod (long...numbers){

        long x = 0;

        for (long nums : numbers) {
            if (nums >= 0) {
                for (long i = 0; i <= nums; i++) {
                    x += i;
                }

            } else {
                for (long i = 0; i >= nums; i--) {
                    x += i;
                }
            }
        }
        return x;
    }
}

