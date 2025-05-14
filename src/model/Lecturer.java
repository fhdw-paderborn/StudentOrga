package model;

/**
 * This class stores information about a student
 */
public class Lecturer extends Person {

    private String department;

    public Lecturer() {
        this("no", "name", 0, "no department");
    }

    public Lecturer(String firstName, String lastName) {
        this(firstName, lastName, 0, "");
    }

    public Lecturer(String firstName, String lastName, int birth, String department) {
        super(firstName, lastName, birth);
        this.department = department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String info() {
        return super.info() + " Department: " + this.department;
    }

}