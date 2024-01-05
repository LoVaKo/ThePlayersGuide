package Countdown;

public class Countdown {

    public static void main(String[] args) {
        countdown(10);
    }

    public static int countdown(int x) {
        if (x > 0) {
            System.out.println(x);
            return x - countdown(x - 1);
        } else return 0;
    }
}
