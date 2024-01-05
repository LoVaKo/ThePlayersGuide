package ThePrototype;

import java.util.Scanner;

public class Prototype {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Setting target number
        int targetNumber = -1;
        do {
            System.out.println("User 1, enter a number between 0 and 100:");
            if (scanner.hasNextInt()) {
                targetNumber = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number between 0 and 100.");
                scanner.next();
            }
        }
        while (targetNumber < 1 || targetNumber > 99);

        // Clearing the console
        for (int i = 0; i < 40; i++) {
            System.out.println("\n");
        }
        System.out.println("User 2, guess the number.");

        // Guessing the number
        boolean gameOver = false;

        while (!gameOver) {
            System.out.println("What is your next guess?");
            if (scanner.hasNextInt()) {
                int guess = scanner.nextInt();

                if (guess < targetNumber) {
                    System.out.println(guess + " is too low.");
                } else if (guess > targetNumber) {
                    System.out.println(guess + " is too high.");
                } else {
                    System.out.println("You guessed the number!");
                    gameOver = true;
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
    }
}
