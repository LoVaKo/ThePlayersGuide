package TPG11;

import java.util.Scanner;

public class Inventory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                Tortuga's Outfitter Shop
                1. Rope
                2. Torches
                3. Climbing Equipment
                4. Clean Water
                5. Machete
                6. Canoe
                7. Food supplies""");

        boolean keepShopping = true;

        // Checking for special discount
        boolean halfPrice = false;

        System.out.println("What is your name?");
        String name = scanner.next();
        if (name.equalsIgnoreCase("Lotte")) {
            System.out.println("Hello Lotte! You get a 50% discount on all items.");
            halfPrice = true;
        }

        while (keepShopping) {
            System.out.println("What number do you want to see the price of?");
            int itemNumber = scanner.nextInt();
            scanner.nextLine();

            String pickedItem = "";
            double itemPrice = 0.0;

            switch (itemNumber) {
                case 1 -> {
                    pickedItem = "Rope";
                    itemPrice = 10.0;
                }
                case 2 -> {
                    pickedItem = "Torches";
                    itemPrice = 15.0;
                }
                case 3 -> {
                    pickedItem = "Climbing Equipment";
                    itemPrice = 25.0;
                }
                case 4 -> {
                    pickedItem = "Clean water";
                    itemPrice = 1.0;
                }
                case 5 -> {
                    pickedItem = "Machete";
                    itemPrice = 20.0;
                }
                case 6 -> {
                    pickedItem = "Canoe";
                    itemPrice = 200.0;
                }
                case 7 -> {
                    pickedItem = "Food supplies";
                    itemPrice = 1.0;
                }
                default -> System.out.println("You must choose a number from 1-7.");
            }
            if (!halfPrice) {
                System.out.println(pickedItem + ": " + itemPrice + " gold.");
            } else {
                System.out.println(pickedItem + ": " + (itemPrice / 2) + " gold.");
            }

            // Continue or not
            System.out.println("Would you like to see the price of another item? Y/N ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("N")) {
                System.out.println("Thank you for shopping!");
                keepShopping = false;
            }
        }
    }
}
