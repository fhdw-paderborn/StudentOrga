package _demo.nullpointer;

/**
 * Klasse A demonstriert das Problem der NullPointerException bei Vererbung.
 */
public class A {
    /**
     * Der Konstruktor ruft die m() Methode auf.
     * WICHTIG: Wenn eine Subklasse diese Klasse erweitert, wird diese m() Methode
     * während der Konstruktion der Basisklasse aufgerufen, bevor die Attribute 
     * der Subklasse initialisiert werden!
     */
    public A() {
        m(); // Polymorphischer Aufruf: kann in Subklassen überschriebene Methode aufrufen
    }

    /**
     * Diese Methode kann in Subklassen überschrieben werden.
     */
    public void m() {
        System.out.println("m aus A");
    }
}
