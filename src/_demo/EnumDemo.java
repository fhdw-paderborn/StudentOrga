package _demo;

/**
 * Demonstrationsklasse zum Thema Enumerationen in Java.
 * Zeigt den Unterschied zwischen herkömmlicher Konstantendefinition
 * und der Verwendung von enum-Typen.
 */
public class EnumDemo {

    /**
     * Traditionelle Methode zur Definition von Konstanten durch statische Felder.
     * Nachteil: Keine Typsicherheit, nur int-Werte, kein Gruppierungskonzept.
     */
    public class Ampelfarbe {
        public static final int ROT = 0;
        public static final int GELB = 1;
        public static final int GRUEN = 2;
    }

    /**
     * Moderne Methode zur Definition von Konstanten durch enum-Typ.
     * Vorteile: Typsicherheit, eingebaute Methoden (ordinal, values, etc.),
     * kann in switch-Anweisungen verwendet werden.
     */
    public enum AmpelfarbeEnum {
        ROT, GELB, GRUEN
    }

    /**
     * Verarbeitet eine Ampelfarbe und gibt entsprechende Information aus.
     * Demonstriert die Verwendung von enum-Typen in switch-Anweisungen.
     * 
     * @param farbe Die zu verarbeitende Ampelfarbe
     */
    public static void info(AmpelfarbeEnum farbe) {
        switch (farbe) {
            case ROT:
                System.out.println(farbe.ordinal() + ": Anhalten");
            break;
            case GELB:
                System.out.println(farbe.ordinal() + ": Achtung");
            break;
            case GRUEN:
                System.out.println(farbe.ordinal() + ": Weiterfahren");
            break;
        }
    }

    /**
     * Hauptmethode zur Demonstration der enum-Funktionalität.
     * Zeigt verschiedene Operationen mit enum-Typen wie Methodenaufruf
     * und Iteration über alle enum-Konstanten.
     * 
     * @param args Kommandozeilenargumente (nicht verwendet)
     */
    public static void main(String[] args) {
        info(AmpelfarbeEnum.ROT);
        info(AmpelfarbeEnum.GELB);
        info(AmpelfarbeEnum.GRUEN);
        for (AmpelfarbeEnum farbe : AmpelfarbeEnum.values()) {
            System.out.println(farbe.toString());
        }
    }
}



