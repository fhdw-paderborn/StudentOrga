package _demo.monatsexception;

public class MonatAusnahme extends Exception {
    public MonatAusnahme(int ungültigerWert) {
        super("Ungültiger Monatswert: " + ungültigerWert + ". Erlaubt sind Werte von 1 bis 12.");
    }
}