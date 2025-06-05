package _demo.nullpointer;

/**
 * Klasse B zeigt einen klassischen NullPointerException-Fall bei Vererbung.
 */
public class B extends A {
        /**
         * Attribut a ist beim Aufruf des Konstruktors von A noch nicht initialisiert!
         */
        private A a;

        /**
         * PROBLEM-ERKLÄRUNG:
         * 1. Wenn ein B-Objekt erstellt wird, ruft Java zuerst den Konstruktor der Superklasse A auf
         * 2. Im Konstruktor von A wird m() aufgerufen
         * 3. Da B die m()-Methode überschreibt, wird B's Version von m() aufgerufen
         * 4. In diesem Moment ist das Attribut 'a' noch NULL, da die Initialisierung 
         *    erst NACH dem Aufruf des Superkonstruktors stattfindet
         * 5. Der Aufruf a.m() in Zeile 24 führt zur NullPointerException
         */
        public B() {
            // Superkonstruktor wird implizit ZUERST aufgerufen: super();
            // Erst DANACH wird a initialisiert
            a = new A();
            m(); // Dieser Aufruf ist unbedenklich, da 'a' bereits initialisiert ist
        }

        /**
         * Überschriebene Methode, die auf das Attribut 'a' zugreift.
         * PROBLEM: Wenn diese Methode während der Konstruktion von A aufgerufen wird,
         * ist 'a' noch null, was zur Exception führt:
         * "Exception in thread "main" java.lang.NullPointerException: Cannot invoke "_demo.nullpointer.A.m()"
         */
        @Override
        public void m() {
            a.m(); // NullPointerException wenn a noch nicht initialisiert ist
            System.out.println("m aus B");
        }

        public static void main(String[] args) {
            new B(); // Erzeugt die NullPointerException
        }
    }
