package TPG7;

import java.util.Scanner;

public class KingdomCalculator {
    public static int kingdomCalculator(int provinces, int duchies, int estates) {
        int totalProvinces = provinces * 6;
        int totalDuchies = duchies * 3;
        return totalProvinces + totalDuchies + estates;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Greetings, your Royal Highness!");
        System.out.println("Which King am I speaking to?");
        String kingName = scanner.next();
        System.out.println("Hello " + kingName + "!");
        System.out.println("Can you provide me with the number of provinces in your Kingdom?");
        int numOfProvinces = scanner.nextInt();
        System.out.println("Thank you! Can you provide me with the number of duchies in your Kingdom?");
        int numOfDuchies = scanner.nextInt();
        System.out.println("Thank you! One last thing. Can you provide me with the number of estates in your Kingdom?");
        int numOfEstates = scanner.nextInt();
        System.out.println("Thank you. Calculating Kingdom points now.");

        int kingdomPoints = kingdomCalculator(numOfProvinces, numOfDuchies, numOfEstates);
        System.out.println("Your Kingdom Points are: " + kingdomPoints + " points.");

    }
}