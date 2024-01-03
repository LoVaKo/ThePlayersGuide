package TPG21;

import java.util.Scanner;
public class Arrow {
    private final Arrowhead arrowhead;
    private final Fletching fletching;
    private final int length;
    private static final Scanner scanner = new Scanner(System.in);

    public Arrow(Arrowhead arrowhead, Fletching fletching, int length) {
        this.arrowhead = arrowhead;
        this.fletching = fletching;
        this.length = length;
    }

    public float getCost() {
        float totalCost = 0;

        // Cost of arrowhead
        if (arrowhead == Arrowhead.STEEL) totalCost += 10;
        else if (arrowhead == Arrowhead.WOOD) totalCost += 3;
        else totalCost += 5;

        // Cost of fletching
        if (fletching == Fletching.PLASTIC) totalCost += 10;
        else if (fletching == Fletching.TURKEY) totalCost += 5;
        else totalCost += 3;

        // Cost of length
        totalCost += (float) (0.05 * length);

        return totalCost;
    }

    public static Arrow createEliteArrow() {
        return new Arrow(Arrowhead.STEEL, Fletching.PLASTIC, 95);
    }

    public static Arrow createBeginnerArrow() {
        return new Arrow(Arrowhead.WOOD, Fletching.GOOSE, 75);
    }

    public static Arrow createMarksmanArrow() {
        return new Arrow(Arrowhead.STEEL, Fletching.GOOSE, 65);
    }

    public static Arrow createCustomArrow() {
        Arrowhead arrowhead = null;
        Fletching fletching = null;

        // Choosing arrowhead
        System.out.println("Pick arrowhead type: Steel, wood or obsidian");
        String userInput1 = scanner.nextLine();

        while (arrowhead == null) {
            switch (userInput1.toLowerCase()) {
                case "wood" -> arrowhead = Arrowhead.WOOD;
                case "steel" -> arrowhead = Arrowhead.STEEL;
                case "obsidian" -> arrowhead = Arrowhead.OBSIDIAN;
                default -> {
                    System.out.println("No match found. Please pick steel, wood or obsidian.");
                    userInput1 = scanner.nextLine();
                }
            }
        }

        // Choosing Fletching
        System.out.println("Pick fletching type: Plastic, goose or turkey");
        String userInput2 = scanner.nextLine();

        while (fletching == null) {
            switch (userInput2.toLowerCase()) {
                case "plastic" -> fletching = Fletching.PLASTIC;
                case "goose" -> fletching = Fletching.GOOSE;
                case "turkey" -> fletching = Fletching.TURKEY;
                default -> {
                    System.out.println("No match found. Please pick plastic, goose or turkey.");
                    userInput2 = scanner.nextLine();
                }
            }
        }

        // Choosing Length
        System.out.println("Pick length between 60 and 100 cm");
        int arrowLength = scanner.nextInt();
        scanner.nextLine();

        while (arrowLength < 60 || arrowLength > 100) {
            System.out.println("Length must be between 60 and 100.");
            System.out.println("Please enter length again");
            arrowLength = scanner.nextInt();
            scanner.nextLine();
        }

        // Creating custom arrow
        return new Arrow(arrowhead, fletching, arrowLength);
    }


    public static void main(String[] args) {
        Arrow newArrow = null;

        System.out.println("Would you like to pick a predefined arrow? [yes/no]");
        String answer = scanner.nextLine();

        switch (answer.toLowerCase()) {
            case "yes":
                System.out.println("""
                    Please pick one of the following arrows by entering the number:
                    1. The Elite arrow
                    2. The Beginner arrow
                    3. The Marksman arrow""");

                int number = scanner.nextInt();
                scanner.nextLine();

                while (newArrow == null) {
                    switch (number) {
                        case 1 -> newArrow = createEliteArrow();
                        case 2 -> newArrow = createBeginnerArrow();
                        case 3 -> newArrow = createMarksmanArrow();
                        default -> {
                            System.out.println("Please enter 1, 2 or 3.");
                            number = scanner.nextInt();
                            scanner.nextLine();
                        }
                    }
                }
                break;

            case "no":
                System.out.println("You did not pick a predefined arrow. We will now create a custom arrow.");
                newArrow = createCustomArrow();

                System.out.println("Creating arrow with " + newArrow.arrowhead.toString().toLowerCase() +
                        " arrowhead, " + newArrow.fletching.toString().toLowerCase() + " fletching, with a length of " +
                        newArrow.length + " cm.");
                break;
        }

        double costOfArrow = newArrow.getCost();
        System.out.println("The price of this arrow is: " + costOfArrow);
    }
}
