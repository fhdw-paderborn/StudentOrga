package _demo;

import model.Lecturer;
import model.Person;
import model.Student;

public class PersonArray {
    public static void main(String[] args) {
        
        Person persons[] = new Person[3];
        
        persons[0] = new Person("Max", "Mustermann");
        persons[1] = new Student("Max", "Student");
        persons[2] = new Lecturer("Max", "Lecturerer");

        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i].info()); // Polymorphismus 
        }
    }
}
