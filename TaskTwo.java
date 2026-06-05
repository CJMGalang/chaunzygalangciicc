class TaskTwo {
    
    //All the different primitive data types excluding double
    boolean bool = true;
    char c1 = 'H';
    char c2 = 'w';
    char c3 = 'r';
    char c4 = 'd';
    char c5 = ' ';
    byte b = 0;
    short s = 1;
    int i = 10;
    long l = 31;
    float f = 2.0F;

    //Concatenation into a String
    String output = "" + c1 + l + i + c5 + c2 + b + c3 + s + c4 + c5 + f + c5 + bool;

    public void main (String[] args) {
        System.out.println(output); //Display the string
    }

}