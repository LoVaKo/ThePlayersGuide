package TPG6;

import java.util.Scanner;

public class ChocolateEggs {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Good morning! Welcome to Chocolate Egg Calculator 1.0.");
        System.out.println("How many eggs have been gathered today?");

        int numEggs = input.nextInt();
        int sisterEggs = numEggs / 4;
        int duckBearEggs = numEggs % 4;

        System.out.println("Each sister gets " + sisterEggs + " eggs. The remaining " + duckBearEggs + " will go to the duckbear.");
        System.out.println("Enjoy your chocolate eggs!");
    }
}
