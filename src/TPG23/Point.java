package TPG23;

public class Point {
    final int x;
    final int y;

    // Constructors (with or without parameters)
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static void main(String[] args) {
        Point point1 = new Point(2,3);
        Point point2 = new Point(-4,0);
        Point point3 = new Point();

        System.out.println(point1.getX() + "," + point1.getY());
        System.out.println(point2.getX() + "," + point2.getY());
        System.out.println(point3.getX() + "," + point3.getY());
    }
}
