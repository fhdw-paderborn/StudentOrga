package _demo.patternmatching;

public class SwitchPatternMatchingDemo {

    private static Object[] objects = new Object[] { "Hallo", 12 };

    public static void main(String[] args) {

        for (Object o : objects) {
            // Without pattern matching in switch
            if (o instanceof String) {
                String s = (String) o;
                if (s.length() > 4) {
                    System.out.println("Without pattern matching (if) " + s);
                }
            } else if (o instanceof Integer) {
                int i = (Integer) o;
                System.out.println("Without pattern matching (if) " + i * 4);
            }

            // With pattern matching in switch
            switch (o) {
                case String s when s.length() > 4 ->
                    System.out.println("With pattern matching (switch) " + s);
                case Integer i ->
                    System.out.println("With pattern matching (switch) " + i * 4);
                default ->
                    System.out.println("Unknown type");
            }
        }
    }
}

