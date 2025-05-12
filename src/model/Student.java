package model;

/**
 * This class stores information about a student
 */
public class Student {

    private static int zaehler = 1000;
    
    private int id;
    private int birth;
    private String firstName, lastName;

    public Student() {
        this("no", "name", 0);
    }

    public Student(Student andererStudend) {
        this(andererStudend.firstName, andererStudend.lastName, andererStudend.birth);
    }

    public Student(String firstName, String lastName, int birth) {
        this.id = Student.zaehler;
        this.birth = birth;
        this.firstName = firstName;
        this.lastName = lastName;
        Student.zaehler++;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void info() {
        System.out.printf("Student: %s %s (Geburtsjahr: %d) ID:%d\n", firstName, lastName, birth, id);
    }

    public boolean equals(Student andererStudend) {
        return this.id != andererStudend.id;
    }
}