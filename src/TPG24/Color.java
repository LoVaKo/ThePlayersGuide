package TPG24;

public class Color {
    //Commonly Used Colors
    public static final Color WHITE = new Color(255, 255, 255);
    public static final Color BLACK = new Color(0, 0, 0);
    public static final Color RED = new Color(255, 0, 0);
    public static final Color ORANGE = new Color(255, 165, 0);
    public static final Color YELLOW = new Color(255, 255, 0);
    public static final Color GREEN = new Color(0, 128, 0);
    public static final Color BLUE = new Color(0, 0, 255);
    public static final Color PURPLE = new Color(128, 0, 128);
    private final int red;
    private final int green;
    private final int blue;
    //Constructor
    public Color(int red, int green, int blue) {
        this.red = Math.min(Math.max(red, 0), 255);
        this.green = Math.min(Math.max(green, 0), 255);
        this.blue = Math.min(Math.max(blue, 0), 255);
    }

    public static void main(String[] args) {
        Color color1 = WHITE;
        Color color2 = new Color(100, 0, 100);
        System.out.println("The first color has the following values: " + color1.getRed() + ", " + color1.getGreen() + ", " + color1.getBlue());
        System.out.println("The second color has the following values: " + color2.getRed() + ", " + color2.getGreen() + ", " + color2.getBlue());
    }

    //Getters
    public int getBlue() {
        return blue;
    }

    public int getGreen() {
        return green;
    }

    public int getRed() {
        return red;
    }

}
