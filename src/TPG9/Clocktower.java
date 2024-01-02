package TPG9;

import java.util.Scanner;

public class Clocktower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What number will you feed the clock?");
        int tickOrTock = scanner.nextInt();

        if (tickOrTock % 2 == 0) {
            System.out.println("Tick");
        } else {
            System.out.println("Tock");
        }
    }
}