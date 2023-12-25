package TPG8;

import java.util.Scanner;
import java.awt.Toolkit;

public class MagicBarrier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ANSI_RED = "\u001B[31m";
        String ANSI_RESET = "\u001B[0m";

        System.out.println("Target row?");
        int targetRow = scanner.nextInt();
        System.out.println("Target column?");
        int targetColumn = scanner.nextInt();

        System.out.println(ANSI_RED + "Deploy to:");
        System.out.println("(" + (targetRow - 1) + "," + targetColumn + ")");
        System.out.println("(" + targetRow + "," + (targetColumn - 1) + ")");
        System.out.println("(" + targetRow + "," + (targetColumn + 1) + ")");
        System.out.println("(" + (targetRow + 1) + "," + targetColumn + ")" + ANSI_RESET);

        Toolkit.getDefaultToolkit().beep(); // Makes a beep sound.
    }
}
