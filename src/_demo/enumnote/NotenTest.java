package _demo.enumnote;

/**
 * Testklasse für die Note-Enumeration.
 * Demonstriert die Verwendung der Noten-Enumeration und deren Methoden.
 */
public class NotenTest {
    /**
     * Hauptmethode zum Testen der Note-Enumeration.
     * Zeigt alle verfügbaren Noten mit ihren Punktebereichen an und
     * demonstriert die Umwandlung von Punktzahlen in Noten.
     * 
     * @param args Kommandozeilenargumente (nicht verwendet)
     */
    public static void main(String[] args) {
        // Alle verfügbaren Noten durchlaufen und anzeigen
        for (Note n : Note.values()) {
            System.out.println(n + ": " + n.getPunkte());
        }
        
        // Demonstration der getNote-Methode mit Beispielpunktzahlen
        System.out.println("50 Punkte: " + Note.getNote(50));  // Sollte AUSREICHEND sein
        System.out.println("82 Punkte: " + Note.getNote(82));  // Sollte SEHR_GUT sein
    }
}
