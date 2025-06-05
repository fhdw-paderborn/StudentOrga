package _demo;

/**
 * Demonstration von Generics mit verschiedenen Varianz-Arten in Java.
 * - Invarianz: Generische Typen ohne Wildcards
 * - Kovarianz: Generische Typen mit ? extends T
 * - Kontravarianz: Generische Typen mit ? super T
 */
public class GenericsVarianzDemo {

    /**
     * Basisklasse für die Tier-Hierarchie
     */
    public static class Tier {
        private String name;

        public Tier(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Tier: " + name;
        }
    }

    /**
     * Unterklasse von Tier
     */
    public static class Hund extends Tier {
        private String rasse;

        public Hund(String name, String rasse) {
            super(name);
            this.rasse = rasse;
        }

        public String getRasse() {
            return rasse;
        }

        @Override
        public String toString() {
            return "Hund: " + getName() + " (" + rasse + ")";
        }
    }

    /**
     * Unterklasse von Hund
     */
    public static class Dackel extends Hund {
        private boolean langHaarig;

        public Dackel(String name, boolean langHaarig) {
            super(name, "Dackel");
            this.langHaarig = langHaarig;
        }

        public boolean isLangHaarig() {
            return langHaarig;
        }

        @Override
        public String toString() {
            return "Dackel: " + getName() + (langHaarig ? " (langhaarig)" : " (kurzhaarig)");
        }
    }

    /**
     * Generische Klasse mit invariantem Typ-Parameter.
     * Invarianz bedeutet: Nur exakt der angegebene Typ ist erlaubt.
     * Box<Hund> ist weder Unter- noch Obertyp von Box<Tier> oder Box<Dackel>.
     */
    public static class Box<T> {
        private T inhalt;

        public Box(T inhalt) {
            this.inhalt = inhalt;
        }

        public T getInhalt() {
            return inhalt;
        }

        public void setInhalt(T inhalt) {
            this.inhalt = inhalt;
        }

        @Override
        public String toString() {
            return "Box mit: " + inhalt;
        }
    }

    /**
     * Methode demonstriert Kovarianz mit dem "? extends" Wildcard.
     * Erlaubt das Lesen von Elementen aus einer Box, die Tier oder jeden Untertyp von Tier enthält.
     * Es können keine Elemente in die Box geschrieben werden (nur lesen).
     * 
     * @param tierBox Eine Box, die Tier oder einen Untertyp von Tier enthält
     */
    public static void zeigeKovarianz(Box<? extends Tier> tierBox) {
        // Lesen ist sicher, da wir wissen, dass mindestens ein Tier enthalten ist
        Tier tier = tierBox.getInhalt();
        System.out.println("Kovarianz - Lesen: " + tier);

        // Schreiben wäre unsicher und wird vom Compiler verhindert:
        // tierBox.setInhalt(new Hund("Rex", "Schäferhund")); // Kompiliert nicht!
    }

    /**
     * Methode demonstriert Kontravarianz mit dem "? super" Wildcard.
     * Erlaubt das Schreiben von Hunden in eine Box, die Hund oder jeden Obertyp von Hund akzeptiert.
     * Beim Lesen aus der Box erhält man nur Objekte vom Typ Object.
     * 
     * @param hundBox Eine Box, die Hund oder einen Obertyp von Hund akzeptiert
     */
    public static void zeigeKontravarianz(Box<? super Hund> hundBox) {
        // Schreiben ist sicher, da die Box mindestens Hunde akzeptiert
        hundBox.setInhalt(new Hund("Bello", "Mischling"));
        hundBox.setInhalt(new Dackel("Waldi", true)); // Auch Untertypen von Hund sind ok

        // Lesen ist eingeschränkt, wir bekommen nur Object zurück
        Object objekt = hundBox.getInhalt();
        System.out.println("Kontravarianz - Lesen als Object: " + objekt);

        // Wir können nicht direkt als Hund lesen, Typumwandlung nötig:
        // Hund hund = hundBox.getInhalt(); // Kompiliert nicht!
    }

    /**
     * Invariante Methode, die exakt eine Box<Hund> erwartet.
     * Hier ist sowohl Lesen als auch Schreiben von Hunden möglich.
     * 
     * @param hundBox Eine Box, die genau Hunde enthält
     */
    public static void zeigeInvarianz(Box<Hund> hundBox) {
        // Lesen als Hund ist sicher
        Hund hund = hundBox.getInhalt();
        System.out.println("Invarianz - Lesen: " + hund);

        // Schreiben von Hunden ist sicher
        hundBox.setInhalt(new Hund("Rex", "Schäferhund"));
        
        // Auch Untertypen von Hund sind erlaubt
        hundBox.setInhalt(new Dackel("Waldi", false));
    }

    public static void main(String[] args) {
        // Invarianz-Beispiele
        Box<Tier> tierBox = new Box<>(new Tier("Allgemeines Tier"));
        Box<Hund> hundBox = new Box<>(new Hund("Bello", "Schäferhund"));
        Box<Dackel> dackelBox = new Box<>(new Dackel("Waldi", true));

        System.out.println("\n--- Invarianz ---");
        System.out.println("Folgende Zuweisungen sind bei invarianten Generics NICHT möglich:");
        System.out.println("Box<Hund> = Box<Tier>; // Fehler - obwohl Hund ein Tier ist");
        System.out.println("Box<Tier> = Box<Hund>; // Fehler - obwohl Hund ein Tier ist");
        
        // Diese Zeilen würden Kompilierungsfehler verursachen:
        // hundBox = tierBox; // Fehler trotz Tier als Oberklasse
        // tierBox = hundBox; // Fehler trotz Hund als Unterklasse

        // Aufruf der invarianten Methode
        zeigeInvarianz(hundBox);
        // zeigeInvarianz(tierBox); // Fehler: erwartet Box<Hund>
        // zeigeInvarianz(dackelBox); // Fehler: erwartet Box<Hund>

        System.out.println("\n--- Kovarianz mit ? extends ---");
        zeigeKovarianz(tierBox);  // Box<Tier> ist Box<? extends Tier>
        zeigeKovarianz(hundBox);  // Box<Hund> ist Box<? extends Tier>
        zeigeKovarianz(dackelBox); // Box<Dackel> ist Box<? extends Tier>

        System.out.println("\n--- Kontravarianz mit ? super ---");
        zeigeKontravarianz(tierBox);  // Box<Tier> ist Box<? super Hund>
        zeigeKontravarianz(hundBox);  // Box<Hund> ist Box<? super Hund>
        // zeigeKontravarianz(dackelBox); // Fehler: Box<Dackel> ist nicht Box<? super Hund>

        System.out.println("\n--- PECS-Prinzip (Producer-Extends, Consumer-Super) ---");
        System.out.println("- Verwende '? extends T', wenn du Werte aus einer Collection lesen willst (Producer)");
        System.out.println("- Verwende '? super T', wenn du Werte in eine Collection schreiben willst (Consumer)");
        System.out.println("- Verwende keine Wildcards, wenn du beides tun willst");
    }
}