package ExeptisGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Game {
    public List<Integer> chosenCookies;
    int isOatmealCookie;
    int round;
    boolean gameOver;

    public Game() {
        Random random = new Random();

        this.chosenCookies = new ArrayList<>();
        chosenCookies.add(1);
        chosenCookies.add(2);
        chosenCookies.add(3);
        chosenCookies.add(4);
        chosenCookies.add(5);
        chosenCookies.add(6);
        chosenCookies.add(7);
        chosenCookies.add(8);
        chosenCookies.add(9);
        chosenCookies.add(10);

        this.isOatmealCookie = random.nextInt(10) + 1;
        this.round = 1;
        this.gameOver = false;
    }

    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        while (!game.gameOver) {

            String currentPlayer = (game.round % 2 == 0) ? "Player 2" : "Player 1";
            System.out.println(currentPlayer + ", take a cookie by choosing a number between 1 and 10.");

            int userInput = 0;
            boolean hasNotBeenPicked = false;
            while (userInput == 0 || !hasNotBeenPicked) {
                if (scanner.hasNextInt()) {
                    userInput = scanner.nextInt();
                } else {
                    System.out.println("Invalid input. Please pick a number between 1 and 10.");
                    scanner.nextLine();
                }

                for (int n : game.chosenCookies) {
                    if (n == userInput) {
                        hasNotBeenPicked = true;
                        break;
                    } else {
                        System.out.println("That number has already been picked. Please pick another number.");
                        scanner.nextLine();
                    }
                }
            }
            if (userInput == game.isOatmealCookie) {
                try {
                    throw new CookieFoundException(currentPlayer + " picked the oatmeal raisin cookie! Program terminated.");
                } catch (CookieFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            game.chosenCookies.remove(Integer.valueOf(userInput));
            game.round++;
            scanner.nextLine();
        }
    }
}
