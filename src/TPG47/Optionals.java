package TPG47;

import java.util.Optional;
import java.util.Scanner;

public class Optionals {
    public static Optional<Integer> isInteger() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide an int value");
        String userInput = scanner.nextLine();

        try {
            int parsedValue = Integer.parseInt(userInput);
            return Optional.of(parsedValue);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public static Optional<Double> isDouble() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide a double value");
        String userInput = scanner.nextLine();

        try {
            double parsedValue = Double.parseDouble(userInput);
            return Optional.of(parsedValue);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public static Optional<Boolean> isBoolean() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide a boolean value");
        String userInput = scanner.nextLine().toLowerCase();

        if (userInput.equals("true") || userInput.equals("false")) {
            return Optional.of(Boolean.parseBoolean(userInput));
        } else {
            return Optional.empty();
        }
    }


    public static void main(String[] args) {
        Optional<Integer> intResult;
        do {
            intResult = isInteger();
            if (intResult.isEmpty()) {
                System.out.println("Invalid input.");
            }
        } while (intResult.isEmpty());

        Optional<Double> doubleResult;
        do {
            doubleResult = isDouble();
            if (doubleResult.isEmpty()) {
                System.out.println("Invalid input.");
            }
        } while (doubleResult.isEmpty());

        Optional<Boolean> boolResult;
        do {
            boolResult = isBoolean();
            if (boolResult.isEmpty()) {
                System.out.println("Invalid input.");
            }
        } while (boolResult.isEmpty());
    }
}
