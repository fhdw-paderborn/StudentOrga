package model;

/**
 * This class stores information about a student
 */
public class Student extends Person {

    private static int zaehler = 1000;

    private int id;
    private String subject;

    public Student() {
        this("no", "name", 0);
    }

    public Student(String firstName, String lastName) {
        this(firstName, lastName, 0);
    }

    public Student(String firstName, String lastName, int birth) {
        super(firstName, lastName, birth);
        this.id = Student.zaehler;
        Student.zaehler++;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String info() {
        return super.info() + "Subject " + subject + " ID:" + id;
    }
}