package TakingANumber;

import java.util.Scanner;

public class TakingANumber {

    static Scanner scanner = new Scanner(System.in);

    public static int askForNumber(String text) {
        System.out.println(text);
        return scanner.nextInt();
    }

    public static int askForNumberInRange(String text, int min, int max) {
        System.out.println(text + "\nRange between: " + min + " and " + max);

        boolean isValid = false;
        int num;
        do {
            num = scanner.nextInt();
            if (num > min && num < max) {
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter a number in the specified range.");
            }
        } while (!isValid);
        return num;
    }

    public static void main(String[] args) {
        System.out.println("You entered: " + askForNumber("Please enter a number: "));
        System.out.println("You entered: " + askForNumberInRange("Please enter a number.", 10, 100));
    }
}
