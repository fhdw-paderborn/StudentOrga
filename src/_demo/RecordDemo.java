package _demo;

public class RecordDemo {
    public record Point(int x, int y) {}

    public static void main(String[] args) {
        var p1 = new Point(10, 10);
        System.out.println(p1);
        System.out.println(p1.x + ";" + p1.y);
    }
}
