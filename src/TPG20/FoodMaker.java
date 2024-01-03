package TPG20;

import java.util.Scanner;

public class FoodMaker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Foodmaker 1.0.");
        System.out.println("What type of food item would you like: Soup, Stew, Gumbo");
        String foodType = scanner.nextLine();
        System.out.println("What type of main ingredïent would you like: Mushroom, Chicken, Carrot, Potato");
        String mainIngredient = scanner.nextLine();
        System.out.println("What type of seasoning would you like: Spicy, Salty, Sweet");
        String seasoning = scanner.nextLine();

        Food recipe = Food.makeFood(foodType, mainIngredient, seasoning);
        System.out.println("\nServing up:");
        System.out.println(recipe.seasoning.toString() + " " + recipe.mainIngredient.toString() + " " + recipe.foodType.toString());

    }

}
