package TheSieve;

import java.util.Scanner;
import java.util.function.Predicate;

public class LambdaSieve {
    Predicate<Integer> filter;

    // Constructor
    public LambdaSieve(Predicate<Integer> filter) {
        this.filter = filter;
    }
    public boolean isGood(int number) {
        return filter.test(number);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Determining filter
        int userInput = 0;
        while (userInput < 1 || userInput > 3) {
            System.out.println("""
                Pick a filter:
                1. is the number even?
                2. is the number positive?
                3. is the number a multiple of 10?""");
            if (scanner.hasNextInt()) {
                userInput = scanner.nextInt();
                if (userInput < 1 || userInput > 3) {
                    System.out.println("Invalid input. Please pick a number between 1 and 3.");
                    scanner.nextLine();
                }
            } else {
                System.out.println("Invalid input. Please pick a number between 1 and 3.");
                scanner.nextLine();
            }
        }

        Predicate<Integer> filter = null;
        switch (userInput) {
            case 1 -> filter = number -> number % 2 == 0;
            case 2 -> filter = number -> number >= 0;
            case 3 -> filter = number -> number % 10 == 0;
        }

        Sieve sieve = new Sieve(filter);
        boolean quit = false;
        while (!quit) {

            // Defining number
            int pickedNumber = 0;
            while(pickedNumber == 0) {
                System.out.print("Please enter a number: ");

                if (scanner.hasNextInt()) {
                    pickedNumber = scanner.nextInt();
                } else {
                    System.out.println("Invalid input. Please pick a number other than 0.");
                    scanner.nextLine();
                }
            }
            boolean isGood = sieve.isGood(pickedNumber);
            if (isGood) {
                System.out.println("The number is Good!");
            } else {
                System.out.println("The number is Bad!");
            }

            System.out.println("Would you like to quit? [y/n]");
            if (scanner.next().equalsIgnoreCase("y")) quit = true;
        }


    }

}
