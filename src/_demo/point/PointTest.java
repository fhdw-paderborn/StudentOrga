package _demo.point;

public class PointTest {
    public static void main(String[] args) {
        Point p1 = new Point();
        p1.display();

        Point p2 = new Point(20);
        p2.display();

        Point p3 = new Point (10,20);
        p3.display();
    }
}
