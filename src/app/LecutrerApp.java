package app;

import model.Lecturer;

public class LecutrerApp {
    public static void main(String[] args) {

        Lecturer lecturer = new Lecturer();
        System.out.println("Lecturer");
        lecturer.newInput();
        System.out.print("Abteilung:\t");
        lecturer.setDepartment(System.console().readLine());
        System.out.println(lecturer.info());
        
    }
}
