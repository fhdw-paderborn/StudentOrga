package _demo;
import java.util.Scanner;

import model.Student;

public class ScannerApp {
    public static void main(String[] args) throws Exception {
        
        // Erzeugt einen neuen Scanner der von System.in (dem Standard Input -> Console) Eingaben scannen kann
        Scanner sc = new Scanner(System.in);

        Student student = new Student();

        System.out.print("FirstName: \t");
        String fname = sc.nextLine(); // vs. sc.next() liest nur das nächste Token bis zum Leerzeichen ein!
        student.setFirstName(fname);

        System.out.print("LastName: \t");
        String name = sc.nextLine(); // vs. sc.next() liest nur das nächste Token bis zum Leerzeichen ein!
        student.setLastName(name);
        
        System.out.print("Birth Year: \t");
        int year = sc.nextInt();
        student.setBirth(year);

        sc.close();

        student.info();

    }
}
