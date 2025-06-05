package _demo;

import java.util.Scanner;


public class ScannerDemo {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Vorname:\t");
        String vorname = scanner.nextLine();

        System.out.print("Name:\t");
        String name = scanner.nextLine();

        System.out.print("Geburtsjahr:\t");
        int birthYear = scanner.nextInt();

        scanner.close();



        System.out.println("Dein Name ist " + vorname + " " + name + " (Geburtsjahr:" + birthYear +")");
    }

}
