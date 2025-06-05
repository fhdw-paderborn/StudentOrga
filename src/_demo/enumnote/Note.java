package _demo.enumnote;

/**
 * Eine Enumeration zur Repräsentation von Schulnoten mit zugehörigen Punktebereichen.
 * Jede Note ist mit einem minimalen und maximalen Punktwert definiert.
 * Bietet Funktionalität zum Ermitteln einer Note basierend auf erreichten Punkten.
 */   
public enum Note {
    /** Beste Note: 82-90 Punkte */
    SEHR_GUT(82, 90), 
    /** Zweitbeste Note: 70-81 Punkte */
    GUT(70, 81), 
    /** Mittlere Note: 58-69 Punkte */
    BEFRIEDIGEND(58, 69), 
    /** Genügende Note: 46-57 Punkte */
    AUSREICHEND(46, 57),
    /** Ungenügende Note: 0-45 Punkte */
    MANGELHAFT(0, 45);

    /** Untere Grenze des Punktebereichs */
    private int von;
    /** Obere Grenze des Punktebereichs */
    private int bis;

    /**
     * Konstruktor für die Note-Enumeration.
     * 
     * @param von Untere Grenze des Punktebereichs
     * @param bis Obere Grenze des Punktebereichs
     */
    private Note(int von, int bis) {
        this.von = von;
        this.bis = bis;
    }

    /**
     * Gibt den Punktebereich der Note als formatierte Zeichenkette zurück.
     * 
     * @return Zeichenkette mit Format "von - bis"
     */
    public String getPunkte() {
        return von + " - " + bis;
    }

    /**
     * Ermittelt die Note anhand der erreichten Punkte.
     * 
     * @param punkte Erreichte Punktzahl
     * @return Die entsprechende Note oder null, wenn keine passende Note gefunden wurde
     */
    public static Note getNote(int punkte) {
        Note result = null;
        for (Note n : Note.values()) {
            if (n.von <= punkte && punkte <= n.bis) {
                result = n;
                break;
            }
        }
        return result;
    }
}

