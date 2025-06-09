package _demo.exceptions;

public class IdGenerator {

    private static final int MAX_ID = 9999;
    private int currentId = 0;

    public int getNextId() throws IdOverflowException {
        if (currentId >= MAX_ID) {
            throw new IdOverflowException("Maximale Anzahl an IDs erreicht: " + MAX_ID);
        }
        return ++currentId;
    }

    public static void main(String[] args) {
        IdGenerator generator = new IdGenerator();

        try {
            for (int i = 0; i < 10010; i++) {
                int id = generator.getNextId();
                System.out.println("Neue ID: " + id);
            }
        } catch (IdOverflowException e) {
            System.err.println("Fehler: " + e.getMessage());
        }
    }
}
