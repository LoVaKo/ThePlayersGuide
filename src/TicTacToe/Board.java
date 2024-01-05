package TicTacToe;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private final Map<Integer, int[]> inputToIndices = new HashMap<>();
    private final String[][] board = {
            {"-", "-", "-"},
            {"-", "-", "-"},
            {"-", "-", "-"}
    };

    public Board() {
        // Mapping indices
        inputToIndices.put(7, new int[]{0, 0});
        inputToIndices.put(8, new int[]{0, 1});
        inputToIndices.put(9, new int[]{0, 2});
        inputToIndices.put(4, new int[]{1, 0});
        inputToIndices.put(5, new int[]{1, 1});
        inputToIndices.put(6, new int[]{1, 2});
        inputToIndices.put(1, new int[]{2, 0});
        inputToIndices.put(2, new int[]{2, 1});
        inputToIndices.put(3, new int[]{2, 2});
    }

    public void print() {
        for (String[] row : board) {
            for (String cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public boolean checkForWin() {

        // Checking rows and columns
        for (int i = 0; i < 3; i++) {
            // Checking rows
            if (hasThreeInRow(board[i][0], board[i][1], board[i][2])) return true;

            // Checking columns
            if (hasThreeInRow(board[0][i], board[1][i], board[2][i])) return true;
        }

        // Checking diagonals
        return hasThreeInRow(board[0][0], board[1][1], board[2][2]) ||
                hasThreeInRow(board[0][2], board[1][1], board[2][0]);
    }

    private boolean hasThreeInRow(String a, String b, String c) {
        return a.equals(b) && b.equals(c) && !a.equals("-");
    }

    public boolean isFull() {
        for (String[] row : board) {
            for (String cell : row) {
                if (cell.equalsIgnoreCase("-")) return false;
            }
        }
        return true;
    }

    public boolean isEmptySpace(int n) {
        int[] index = inputToIndices.get(n);
        int row = index[0];
        int column = index[1];

        return board[row][column].equals("-");
    }

    public void addToken(String token, int pickedSquare) {
        int[] index = inputToIndices.get(pickedSquare);
        int row = index[0];
        int column = index[1];

        board[row][column] = token;
    }

}
