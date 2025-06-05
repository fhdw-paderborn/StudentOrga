package _demo;

import model.Lecturer;
import model.Person;

public class UpDownCast {
    public static void main(String[] args) {

        Lecturer lect1 = new Lecturer("Max", "Mustermann");
        System.out.println(((Person)lect1).info());

        Lecturer lect2 = new Lecturer("Maxi", "Musterfrau", 1964, "Computer Science");
        System.out.println(lect2.info());

        // Upcast
        Person person3 = new Lecturer("Moni", "Müller");
        System.out.println(person3.info());

        // Downcast
        ((Lecturer)person3).setDepartment("Computer Science");
        System.out.println(((Lecturer)person3).getDepartment());

        Lecturer lect3 = (Lecturer) person3;
        System.out.println(lect3.info());
    }
}
