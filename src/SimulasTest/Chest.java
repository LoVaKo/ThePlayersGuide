package SimulasTest;

import java.util.Scanner;

public class Chest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChestState lock = ChestState.LOCKED;

        while (true) {
            System.out.println("The chest is " + lock.toString().toLowerCase() + ". What do you want to do?");
            String command = scanner.nextLine().toLowerCase();
            switch (command) {
                case "open":
                    if (lock == ChestState.UNLOCKED) {
                        lock = ChestState.OPEN;
                    } else if (lock == ChestState.OPEN) {
                        System.out.println("The chest is already open.");
                    } else {
                        System.out.println("The chest is locked and cannot be opened.");
                    }
                    break;
                case "close":
                    if (lock == ChestState.UNLOCKED) {
                        System.out.println("The chest is already closed.");
                    } else if (lock == ChestState.OPEN) {
                        lock = ChestState.UNLOCKED;
                    } else {
                        System.out.println("The chest is already closed.");
                    }
                    break;
                case "unlock":
                    if (lock == ChestState.UNLOCKED) {
                        System.out.println("The chest is already unlocked.");
                    } else if (lock == ChestState.OPEN) {
                        System.out.println("The chest is already open.");
                    } else {
                        lock = ChestState.UNLOCKED;
                    }
                    break;
                case "lock":
                    if (lock == ChestState.UNLOCKED) {
                        lock = ChestState.LOCKED;
                    } else if (lock == ChestState.OPEN) {
                        System.out.println("The chest is open.");
                    } else {
                        System.out.println("The chest is already locked.");
                    }
                    break;
                default:
                    System.out.println("Invalid input. Please choose one of the following commands: open, close, unlock, lock.");
                    break;
            }
        }
    }
}