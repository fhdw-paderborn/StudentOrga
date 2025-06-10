package _demo.st;

public class Logic {
    public void process() {
        System.out.println("Logikverarbeitung gestartet.");
        calculate();
    }

    private void calculate() {
        System.out.println("Berechnung gestartet.");
        int result = divide(10, 0);  // Fehler: Division durch 0
        System.out.println("Ergebnis: " + result);
    }

    private int divide(int a, int b) {
        return a / b;  // Hier tritt die Exception auf
    }
}