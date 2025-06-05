package _demo.point;

public record Point(int x, int y) {
    private static final int ZERO = 0;

    public Point() {
        this(ZERO, ZERO);
    }

    public Point(int value) {
        this(value, value);
    }

    public Point(int x, int y) {
        this.x = x >= 0 ? x : 0;
        this.y = y >= 0 ? y : 0;
    }
    public void display() {
        System.out.println("("+ this.x + ", "+ this.y +")");
    }
}

    

