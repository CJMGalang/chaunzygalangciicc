class Student {

    private String firstName;
    private String lastName;

    public Student (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //Personal code starts here.
    
    public String getFirstName () {
        return firstName;
    }

    public String getLastName () {
        return lastName;
    }

    void printFullName () {
        System.out.println(getFirstName() + " " + getLastName());
    }

    //Personal code ends here.
    
}

public class Task10 {
    public static void main (String[] args) {
        Student[] students = new Student[] {
                new Student ("Morgan", "Freeman"),
                new Student ("Brad", "Pitt"),
                new Student ("Kevin", "Spacey"),
        };

        for (Student s: students) {
            s.printFullName();
        }

    }
}
