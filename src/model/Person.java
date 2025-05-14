package model;

public class Person {

    protected String firstName, lastName;
    protected int birth;
    protected String city;

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

    public void setCity(String city) {
        this.city = city;
    }
    
    public String info() {
        return firstName + " " + lastName + " Geburtsdatum (" + birth + ") " + " City: " + this.city ;
    }

    public void newInput() {
        
        System.out.print("FirstName: \t");
        this.setFirstName(System.console().readLine());

        System.out.print("LastName: \t");
        this.setLastName(System.console().readLine());

        System.out.print("City: \t");
        this.setCity(System.console().readLine());
        
        System.out.print("Birth Year: \t");
        int year = Integer.valueOf(System.console().readLine());
        this.setBirth(year);
    }

}