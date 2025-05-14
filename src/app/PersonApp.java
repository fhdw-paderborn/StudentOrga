package app;

import model.Person;

public class PersonApp {
    public static void main(String[] args) {

        Person p1 = new Person();
        System.out.println("Person 1 - Eingabe");
        p1.newInput();
        System.out.println(p1.info());

        Person p2 = new Person();
        System.out.println("Person 2 - Eingabe");
        p2.newInput();
        System.out.println(p2.info());

    }
}
