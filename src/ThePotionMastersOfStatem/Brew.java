package ThePotionMastersOfStatem;


import java.util.Scanner;

public class Brew {
    Potion potion;
    boolean isRuined;
    boolean isFinished;

    public Brew() {
        this.potion = new Potion();
        isRuined = false;
        isFinished = false;
    }

    public static void main(String[] args) {
        boolean newGame = true;
        while (newGame) {
            Brew brew = new Brew();
            Scanner scanner = new Scanner(System.in);

            // Loop for mixing the potion
            while (!brew.isRuined && !brew.isFinished) {
                // Picking new ingrediënt
                System.out.println();
                System.out.println("Current potion type: " + brew.potion.type.toString().toLowerCase());
                System.out.println("""
                        POSSIBLE INGREDIËNTS
                        --------------------
                        | 1. Stardust      |
                        | 2. Snake venom   |
                        | 3. Dragon breath |
                        | 4. Shadow glass  |
                        | 5. Eyeshine gem  |
                        --------------------""");

                System.out.println("Which ingrediënt do you want to add to your potion?");

                if (scanner.hasNextInt()) {
                    int pickedIngredient = scanner.nextInt();
                    scanner.nextLine();

                    if (pickedIngredient > 0 && pickedIngredient < 6) {
                        switch (pickedIngredient) {
                            case 1 -> brew.potion.add(Ingredient.STARDUST, brew.potion.getType());
                            case 2 -> brew.potion.add(Ingredient.SNAKE_VENOM, brew.potion.getType());
                            case 3 -> brew.potion.add(Ingredient.DRAGON_BREATH, brew.potion.getType());
                            case 4 -> brew.potion.add(Ingredient.SHADOW_GLASS, brew.potion.getType());
                            case 5 -> brew.potion.add(Ingredient.EYESHINE_GEM, brew.potion.getType());
                        }
                    } else {
                        System.out.println("Pick a number from 1 to 5.");
                    }
                } else {
                    System.out.println("Please enter a number corresponding with an ingrediënt from the list.");
                }

                // Checking for ruined potion
                // Completing the potion or adding more ingrediënts
                if (brew.potion.getType().equals(PotionType.RUINED_POTION)) {
                    brew.setRuined(true);
                } else {
                    System.out.println();
                    System.out.println("Do you want to add more ingrediënts to your potion? [y/n]");
                    if (scanner.nextLine().equalsIgnoreCase("n")) brew.setFinished(true);
                }
            }

            // Give the player the option to exit the loop
            System.out.println();
            System.out.println("Would you like to brew another potion? [y/n]");
            if (scanner.nextLine().equalsIgnoreCase("n")) newGame = false;
        }
    }

    public void setRuined(boolean ruined) {
        isRuined = ruined;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }
}
