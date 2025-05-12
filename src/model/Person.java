package model;

public class Person {
    private String firstName, lastName;
    private int birth;

    public Person() {
    }
    
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName, int birth) {
        this(firstName, lastName);
        this.birth = birth;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setBirth(int birth) {
        this.birth = birth;
    }
    
    public void info() {
        System.out.printf("Person: %s %s (Geburtsjahr: %d)\n", firstName, lastName, birth);
    }

}