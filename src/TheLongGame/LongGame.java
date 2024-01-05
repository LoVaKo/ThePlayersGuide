package TheLongGame;

import java.io.*;
import java.util.Scanner;

public class LongGame {
    String username;
    int score;
    boolean gameOver;
    File savedScore;

    public LongGame(String username) {
        this.score = 0;
        this.username = username;
        this.gameOver = false;
        this.savedScore = new File(username + ".txt");

        try {
            if (savedScore.createNewFile()) {
                System.out.println("A new game has been created.");
            } else {
                System.out.println("Welcome back " + username + "!");
                loadPreviousScore();
            }
        } catch (IOException e) {
            System.out.println("An error occured while creating the score file.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // Starting up new game
        System.out.print("Welcome to the Long Game! Please enter your name: ");
        String username = scanner.nextLine();
        LongGame game = new LongGame(username);

        while (!game.gameOver) {
            // Writing
            System.out.println(game.username + ", your current score is: " + game.score);
            System.out.println("Next round!");
            String userInput = scanner.nextLine();

            // Ending the round
            if (userInput.equalsIgnoreCase("IO")) {
                game.gameOver = true;
                System.out.println(game.username + ", your FINAL score is: " + game.score);
                game.saveScore();
            } else {
                game.score += userInput.length();
            }
        }
    }

    public void saveScore() throws IOException {
        FileWriter writer = new FileWriter(this.savedScore);
        writer.write(String.valueOf(this.score));
        writer.close();
    }

    public void loadPreviousScore() throws IOException {
        FileReader fileReader = new FileReader(this.savedScore);
        BufferedReader reader = new BufferedReader(fileReader);
        String score = reader.readLine();

        if (score != null) {
            this.score = Integer.parseInt(score.trim());
            System.out.println("Score loaded from savefile: " + this.score);
        } else {
            System.out.println("File is empty or doesn't contain a score.");
        }
        reader.close();
        fileReader.close();
    }
}
