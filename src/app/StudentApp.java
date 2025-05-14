package app;

import model.Student;

public class StudentApp {
    public static void main(String[] args) {

        Student student1 = new Student();
        System.out.println("Student");
        student1.newInput();
        System.out.print("Subject:\t");
        student1.setSubject(System.console().readLine());
        System.out.println(student1.info());
        
    }
}
