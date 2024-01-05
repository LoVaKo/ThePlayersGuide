package TheWatchtower;

import java.util.Scanner;

public class Watchtower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Provide coördinate x");
        int x = sc.nextInt();
        System.out.println("Provide coördinate y");
        int y = sc.nextInt();

        if (y == 0 && x == 0) {
            System.out.println("The enemy is here!");
        } else if (y == 0) {
            System.out.println(x > 0 ? "The enemy is to the east!" : "The enemy is to the west!");
        } else if (x == 0) {
            System.out.println(y > 0 ? "The enemy is to the north!" : "The enemy is to the south!");
        } else {
            System.out.println("The enemy is to the " + (y > 0 ? "north" : "south") + "-" + (x > 0 ? "east" : "west") + "!");
        }
    }
}
