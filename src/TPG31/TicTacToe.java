package TPG31;

import java.util.Scanner;

public class TicTacToe {
    private final Player player1;
    private final Player player2;
    private final Board board = new Board();
    private Player currentPlayer;
    private int round = 0;
    private boolean gameOver = false;

    public TicTacToe() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player 1, what is your name?");
        String player1 = scanner.nextLine();
        System.out.println("Player 2, what is your name?");
        String player2 = scanner.nextLine();

        this.player1 = new Player(player1, "X");
        this.player2 = new Player(player2, "O");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            TicTacToe game = new TicTacToe();

            while (!game.gameOver) {
                game.setUpRound();
                game.pickingSquare();
                game.checkForGameOver();

                if (game.gameOver) break;
                game.round++;
            }

            System.out.println("Would you like to start a new game? [yes/no]");
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("no")) {
                System.out.println("Until next time!");
                exit = true;
            }
        }
    }

    private void setUpRound() {
        setCurrentPlayer();
        System.out.println("\nIt's " + currentPlayer.name() + "'s turn!");
        board.print();
    }

    private void pickingSquare() {
        boolean isValid = false;
        int pickedSquare = -1;
        Scanner scanner = new Scanner(System.in);

        System.out.println(currentPlayer.name() + ", which square do you choose?");

        while (!isValid) {
            if (scanner.hasNextInt()) {
                pickedSquare = scanner.nextInt();
                if (isValidChoice(pickedSquare)) {
                    isValid = true;
                } else {
                    System.out.println("Invalid choice. Please pick a number from 1 - 9," +
                            "\nand make sure the space is empty.");
                }
            } else {
                System.out.println("Invalid choice. Please pick a number from 1 - 9," +
                        "\nand make sure the space is empty.");
            }
        }

        board.addToken(currentPlayer.token(), pickedSquare);
    }

    private void checkForGameOver() {
        if (board.checkForWin()) {
            System.out.println(currentPlayer.name() + " has won the game!");
            gameOver = true;
        } else if (board.isFull()) {
            System.out.println("The board is full. It's a draw!");
            gameOver = true;
        }
    }

    private void setCurrentPlayer() {
        if (this.round % 2 == 0) {
            this.currentPlayer = player1;
        } else {
            this.currentPlayer = player2;
        }
    }

    private boolean isValidChoice(int n) {
        return n >= 1 &&
                n <= 9 &&
                this.board.isEmptySpace(n);
    }


}
