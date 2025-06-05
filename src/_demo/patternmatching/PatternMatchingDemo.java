package _demo.patternmatching;

public class PatternMatchingDemo {
    
    private static Object[] objects = new Object[]{"Hallo", 12};
    
    public static void main(String[] args) {
        
        for(Object o : objects) {
            // For Pattern Matching
            if(o instanceof String) {
                String s = (String) o;
                if(s.length() > 4) {
                    System.out.println("Without pattern matching " + s);
                }
            } else if (o instanceof Integer) {
                int i = (Integer) o;
                System.out.println("Without pattern matching " + i*4);
            }


            // Mit Pattern Matching
            if(o instanceof String s && s.length() > 4) {
                System.out.println("With pattern matching " + s);
            } else if (o instanceof Integer i) {
                System.out.println("With pattern matching " +i*4);
            }
        }
    }
}
