package TPG26;

import java.util.Scanner;
public class Door {
    private DoorState state;
    private int passcode;

    // Constructor
    public Door(int passcode) {
        this.state = DoorState.CLOSED;
        this.passcode = passcode;
    }

    // Setters
    public void setPasscode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter current password");


        int userInput = scanner.nextInt();

        if(userInput == this.passcode) {
            int newPasscode;
            while(true) {
                System.out.println("Please enter new passcode");
                if (scanner.hasNextInt()) {
                    newPasscode = scanner.nextInt();
                    scanner.nextLine();
                    this.passcode = newPasscode;
                    System.out.println("Passcode updated.");
                    break;
                } else {
                    System.out.println("Invalid input. New password must contain numbers only.");
                    scanner.nextLine();
                }
            }
        } else {
            System.out.println("Password incorrect.");
        }
    }
    public void openDoor() {
        DoorState currentState = this.state;

        switch (currentState) {
            case DoorState.OPEN -> System.out.println("Door is already open.");
            case DoorState.CLOSED -> {
                System.out.println("Opening door");
                this.state = DoorState.OPEN;}
            case DoorState.LOCKED -> System.out.println("Can't open locked door.");
        }
    }
    public void closeDoor() {
        DoorState currentState = this.state;

        switch (currentState) {
            case DoorState.OPEN -> {
                System.out.println("Closing door.");
                this.state = DoorState.CLOSED;}
            case DoorState.CLOSED, DoorState.LOCKED -> System.out.println("Door is already closed.");
        }
    }
    public void lockDoor() {
        DoorState currentState = this.state;

        switch (currentState) {
            case DoorState.OPEN -> System.out.println("Cannot lock an open door.");
            case DoorState.CLOSED -> {
                System.out.println("Locking door.");
                this.state = DoorState.LOCKED;}
            case DoorState.LOCKED -> System.out.println("Door is already locked.");
        }
    }
    public void unlockDoor() {
        Scanner scanner = new Scanner(System.in);
        DoorState currentState = this.state;

        switch (currentState) {
            case DoorState.OPEN -> System.out.println("Door is already open.");
            case DoorState.CLOSED -> System.out.println("Door is already unlocked.");
            case DoorState.LOCKED -> {
                System.out.println("Please enter passcode");
                if (scanner.hasNextInt()) {
                    int passcode = scanner.nextInt();
                    scanner.nextLine();
                    if (passcode == this.passcode) {
                        System.out.println("Unlocking door.");
                        this.state = DoorState.CLOSED;
                    } else {
                        System.out.println("Passcode incorrect. Door remains locked.");
                    }
                } else {
                    System.out.println("Passcode is always a number.");
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating new Door.
        int passcode;
        while (true) {
            System.out.println("Please set the passcode for your door. Only numbers are allowed.");
            if (scanner.hasNextInt()) {
                passcode = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Invalid input. Please enter only numbers.");
                scanner.nextLine();
            }
        }

        Door door = new Door(passcode);

        while (true) {
            System.out.println("\nThe door is " + door.state.toString().toLowerCase() + ". " +
                    "\nWhat would you like to do?" +
                    "\n[open/close/lock/unlock]");

            String userInput = scanner.nextLine();

            switch (userInput.toLowerCase()) {
                case "open" -> door.openDoor();
                case "close" -> door.closeDoor();
                case "lock" -> door.lockDoor();
                case "unlock" -> door.unlockDoor();
                default -> System.out.println("Command not recognized");
            }
        }
    }
}
