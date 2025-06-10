package _demo.monatsexception;

public class Monat {
    private int monat;

    public Monat(int monat) throws MonatAusnahme {
        if (monat < 1 || monat > 12) {
            throw new MonatAusnahme(monat);
        }
        this.monat = monat;
    }

    public String getMonatsname() {
        String[] monate = {
            "Januar", "Februar", "März", "April", "Mai", "Juni",
            "Juli", "August", "September", "Oktober", "November", "Dezember"
        };
        return monate[monat - 1];
    }

    public static void main(String[] args) {
        try {
            new Monat(13);
        } catch (Exception e) {
            System.out.println("upsi " + e.getMessage());
            e.printStackTrace();
        }
    }
}
