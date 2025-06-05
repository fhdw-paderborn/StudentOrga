package _demo;

import model.Lecturer;
import model.Person;

public class Instanceof {


    
    public static void main(String[] args) {
        Person p = new Lecturer("Max", "Mustermann", 1999, "IT");

        if(p instanceof Lecturer) {
            System.out.println(((Lecturer)p).getDepartment());
    }
}

    

}
