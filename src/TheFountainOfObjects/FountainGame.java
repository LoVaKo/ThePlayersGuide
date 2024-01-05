package TheFountainOfObjects;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

public class FountainGame {
    // AnsiColors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_MAGENTA = "\u001B[35m";
    Room[][] board;
    GameSize gameSize;
    int boardHeight;
    int boardWidth;
    Coordinate currentLocation;
    Room currentRoom;
    Fountain fountain = new Fountain();
    Boolean gameOver = false;
    int playerAmmo = 5;

    // Constructor
    public FountainGame(GameSize gameSize) {
        this.gameSize = gameSize;
        this.determineBoardSize(gameSize);
        this.setUpEmptyBoard();
        this.setUpSpecialRooms(gameSize);

        // Setting up rest of the game
        this.currentLocation = new Coordinate(0, 0);
        this.currentRoom = board[0][0];
    }

    public static void getCommandList() {
        System.out.println("""
                AVAILABLE COMMANDS
                move north > Move to the cavern to the north
                move south > Move to the cavern to the south
                move west > Move to the cavern to the west
                move east > Move to the cavern to the east
                shoot north > Shoot an arrow in the cavern to the north
                shoot south > Shoot an arrow in the cavern to the south
                shoot west > Shoot an arrow in the cavern to the west
                shoot east > Shoot an arrow in the cavern to the east
                enable fountain > Turn on the fountain of objects (if you're in the same cavern)
                help > Display list with all available commands""");
        System.out.println();
    }

    // MAIN
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Picking game size
        GameSize gameSize = GameSize.NONE;

        while (gameSize.equals(GameSize.NONE)) {

            System.out.println("Welcome to the Fountain of Objects: The game!\n");
            System.out.println("""
                    You enter the Cavern of Objects, a maze of rooms filled with dangerous pits in search of the Fountain of Objects.
                    Light is visible only in the entrance, and no other light is seen anywhere in the caverns.
                    You must navigate the Caverns with your other senses.
                    Find the Fountain of Objects, activate it, and return to the entrance.
                                        
                    But danger lurks around the corner...
                    Look out for pits. You will feel a breeze if a pit is in an adjacent room. If you enter a room with a pit, you will die.
                    Maelstroms are violent forces of sentient wind. Entering a room with one could transport you to any other location in the caverns.\s
                    You will be able to hear their growling and groaning in nearby rooms.
                    Amaroks roam the caverns. Encountering one is certain death, but you can smell their rotten stench in nearby rooms.
                    You carry with you a bow and a quiver of arrows. You can use them to shoot monsters in the caverns but be warned: you have a limited supply.
                                        
                    You can sense danger in the 8 caverns surrounding the one you're in. You can move and shoot ONLY in 4 directions.
                    use the commands 'move' and 'shoot' in combination with a direction (north, south, east, west) to progress through the caverns.\s
                    When encountering the fountain, use the command 'enable fountain'.\s
                    For a full list of commands, enter 'help' at any point in the game.
                    Good luck!""");

            System.out.println("\nWould you like to play a small, medium or large game?");

            String pickedSize = scanner.nextLine();
            if (pickedSize.equalsIgnoreCase(String.valueOf(GameSize.SMALL))) {
                gameSize = GameSize.SMALL;
            } else if (pickedSize.equalsIgnoreCase(String.valueOf(GameSize.MEDIUM))) {
                gameSize = GameSize.MEDIUM;
            } else if (pickedSize.equalsIgnoreCase(String.valueOf(GameSize.LARGE))) {
                gameSize = GameSize.LARGE;
            } else {
                System.out.println("Invalid input. Please choose small, medium, or large.");
                scanner.nextLine();
            }
        }

        // Creating game
        FountainGame game = new FountainGame(gameSize);
        LocalDateTime startingTime = LocalDateTime.now();

        while (!game.gameOver) {
            // Setting up the room
            System.out.println();
            game.setCurrentRoom();
            System.out.println(ANSI_MAGENTA + "You are in the room with the following " + game.currentLocation + ANSI_RESET);
            game.displayBoard();
            System.out.println(ANSI_MAGENTA + "You currently have " + game.playerAmmo + " arrows." + ANSI_RESET);
            System.out.println();
            game.checkForSpecialRoom(game.currentRoom);
            System.out.println();
            if (game.gameOver) {
                LocalDateTime endTime = LocalDateTime.now();
                int minutes = (int) Duration.between(startingTime, endTime).toMinutes();
                System.out.println("Minutes spent in the caverns: " + minutes);
                break;
            }

            System.out.println("What would you like to do?");
            String userInput = scanner.nextLine().toLowerCase();
            switch (userInput) {
                case "move north":
                    game.move(Direction.NORTH);
                    break;
                case "move south":
                    game.move(Direction.SOUTH);
                    break;
                case "move west":
                    game.move(Direction.WEST);
                    break;
                case "move east":
                    game.move(Direction.EAST);
                    break;
                case "shoot north":
                    game.shoot(Direction.NORTH);
                    break;
                case "shoot south":
                    game.shoot(Direction.SOUTH);
                    break;
                case "shoot east":
                    game.shoot(Direction.EAST);
                    break;
                case "shoot west":
                    game.shoot(Direction.WEST);
                    break;
                case "enable fountain":
                    if (game.currentRoom.isFountain()) {
                        game.fountain.setEnabled(true);
                    } else {
                        System.out.println(ANSI_RED + "You cannot enable the fountain, since it is not in this room." + ANSI_RESET);
                    }
                    break;
                case "help":
                    getCommandList();
                    break;
                default:
                    System.out.println(ANSI_RED + "Invalid input" + ANSI_RESET);
            }
        }
    }

    private void determineBoardSize(GameSize gameSize) {
        switch (gameSize) {
            case SMALL -> {
                boardWidth = 4;
                boardHeight = 4;
            }
            case MEDIUM -> {
                boardWidth = 6;
                boardHeight = 6;
            }
            case LARGE -> {
                boardWidth = 8;
                boardHeight = 8;
            }
        }
    }

    private void setUpEmptyBoard() {
        board = new Room[boardWidth][boardHeight];
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardHeight; j++) {
                board[i][j] = new Room(new Coordinate(i, j));
            }
        }
    }

    private void setUpSpecialRooms(GameSize gameSize) {
        // Setting up special rooms depending on game size
        switch (gameSize) {
            case SMALL -> {
                board[0][0].setEntrance(true);
                board[0][2].setFountain(true);
                board[2][2].setPit(true);
                board[1][1].setHasMaelstrom(true);
                board[0][3].setHasAmarok(true);
            }
            case MEDIUM -> {
                board[0][0].setEntrance(true);
                board[3][1].setFountain(true);
                board[3][2].setPit(true);
                board[5][0].setPit(true);
                board[1][4].setHasMaelstrom(true);
                board[2][5].setHasAmarok(true);
                board[0][3].setHasAmarok(true);
            }
            case LARGE -> {
                board[0][0].setEntrance(true);
                board[2][6].setFountain(true);
                board[0][1].setPit(true);
                board[2][3].setPit(true);
                board[4][4].setPit(true);
                board[5][0].setPit(true);
                board[1][5].setHasMaelstrom(true);
                board[2][6].setHasMaelstrom(true);
                board[3][2].setHasAmarok(true);
                board[4][1].setHasAmarok(true);
                board[6][3].setHasAmarok(true);
            }
        }
    }

    // Moving around the board
    public void move(Direction direction) {
        boolean noRoom = true;

        switch (direction) {
            case NORTH -> {
                if (currentLocation.row > 0) {
                    currentLocation.row -= 1;
                    noRoom = false;
                }
            }
            case SOUTH -> {
                if (currentLocation.row < boardHeight - 1) {
                    currentLocation.row += 1;
                    noRoom = false;
                }
            }
            case WEST -> {
                if (currentLocation.column > 0) {
                    currentLocation.column -= 1;
                    noRoom = false;
                }
            }
            case EAST -> {
                if (currentLocation.column < boardWidth - 1) {
                    currentLocation.column += 1;
                    noRoom = false;
                } else System.out.println(ANSI_RED + "There's no room to the east." + ANSI_RESET);
            }
        }

        if (noRoom) {
            System.out.println(ANSI_RED + "There's no room to the " + direction + "." + ANSI_RESET);
        }
    }

    // Other game mechanics
    public void setCurrentRoom() {
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                if (board[i][j].roomLocation().isMatchWith(currentLocation)) {
                    currentRoom = board[i][j];
                }
            }
        }
    }

    public boolean isAdjacentTo(RoomType type) {
        int row = currentLocation.row;
        int column = currentLocation.column;

        // Checking if there are adjacent rooms and defining them.
        Room northRoom = (row > 0) ? this.board[row - 1][column] : null;
        Room southRoom = (row < this.boardHeight - 1) ? this.board[row + 1][column] : null;
        Room westRoom = (column > 0) ? this.board[row][column - 1] : null;
        Room eastRoom = (column < this.boardWidth - 1) ? this.board[row][column + 1] : null;
        Room northEastRoom = (row > 0 && column < this.boardWidth - 1) ? this.board[row - 1][column + 1] : null;
        Room northWestRoom = (row > 0 && column > 0) ? this.board[row - 1][column - 1] : null;
        Room southEastRoom = (row < this.boardHeight - 1 && column < this.boardWidth - 1) ? this.board[row + 1][column + 1] : null;
        Room southWestRoom = (row < this.boardHeight - 1 && column > 0) ? this.board[row + 1][column - 1] : null;

        // Checking for special rooms
        return switch (type) {
            case PIT -> (northRoom != null && northRoom.isPit()) ||
                    (southRoom != null) && southRoom.isPit() ||
                    (westRoom != null) && westRoom.isPit() ||
                    (eastRoom != null) && eastRoom.isPit() ||
                    (northEastRoom != null) && northEastRoom.isPit() ||
                    (northWestRoom != null) && northWestRoom.isPit() ||
                    (southEastRoom != null) && southEastRoom.isPit() ||
                    (southWestRoom != null) && southWestRoom.isPit();
            case AMAROK -> (northRoom != null) && northRoom.hasAmarok() ||
                    (southRoom != null) && southRoom.hasAmarok() ||
                    (westRoom != null) && westRoom.hasAmarok() ||
                    (eastRoom != null) && eastRoom.hasAmarok() ||
                    (northEastRoom != null) && northEastRoom.hasAmarok() ||
                    (northWestRoom != null) && northWestRoom.hasAmarok() ||
                    (southEastRoom != null) && southEastRoom.hasAmarok() ||
                    (southWestRoom != null) && southWestRoom.hasAmarok();
            case MAELSTROM -> (northRoom != null && northRoom.hasMaelstrom()) ||
                    (southRoom != null) && southRoom.hasMaelstrom() ||
                    (westRoom != null) && westRoom.hasMaelstrom() ||
                    (eastRoom != null) && eastRoom.hasMaelstrom() ||
                    (northEastRoom != null) && northEastRoom.hasMaelstrom() ||
                    (northWestRoom != null) && northWestRoom.hasMaelstrom() ||
                    (southEastRoom != null) && southEastRoom.hasMaelstrom() ||
                    (southWestRoom != null) && southWestRoom.hasMaelstrom();
        };
    }

    public void checkForSpecialRoom(Room room) {
        // Immediate action
        if (room.isPit()) {
            System.out.println(ANSI_RED + "You fell into a pit! You lost the game." + ANSI_RESET);
            gameOver = true;
            return;
        }
        if (room.hasAmarok()) {
            System.out.println(ANSI_RED + "An Amarok jumped and killed you! You lost the game." + ANSI_RESET);
            gameOver = true;
            return;
        }
        if (room.hasMaelstrom()) {
            System.out.println(ANSI_RED + "There's a maelstrom in the room that swept you away! The maelstrom has also moved to a new location." + ANSI_RESET);
            currentRoom.setHasMaelstrom(false);
            moveMaelstrom();
            movePlayerByMaelstrom();
            setCurrentRoom();
            System.out.println(ANSI_MAGENTA + "You are in the room with the following " + this.currentLocation + ANSI_RESET);
        }

        // Information on current room
        if (room.isEntrance()) {
            if (!fountain.isEnabled) {
                System.out.println(ANSI_YELLOW + "You see light coming from the cavern entrance." + ANSI_RESET);
            } else {
                System.out.println(ANSI_GREEN + "The Fountain of Objects has been reactivated, and you have escaped with your life!");
                System.out.println("You win!" + ANSI_RESET);
                this.gameOver = true;
                return;
            }
        }
        if (room.isFountain()) {
            if (!fountain.isEnabled) {
                System.out.println(ANSI_BLUE + "You hear water dripping in this room. The Fountain of Objects is here!" + ANSI_RESET);
            } else {
                System.out.println(ANSI_BLUE + "You hear the rushing waters from the Fountain of Objects. It has been reactivated!" + ANSI_RESET);
            }
        }

        // Information on nearby rooms
        if (isAdjacentTo(RoomType.PIT)) {
            System.out.println(ANSI_YELLOW + "You feel a draft. There is a pit in an adjacent room." + ANSI_RESET);
        }
        if (isAdjacentTo(RoomType.MAELSTROM)) {
            System.out.println(ANSI_YELLOW + "You hear the growling and groaning of a maelstrom nearby." + ANSI_RESET);
        }
        if (isAdjacentTo(RoomType.AMAROK)) {
            System.out.println(ANSI_YELLOW + "You can smell the rotten stench of an amarok in a nearby room." + ANSI_RESET);
        }
    }

    public void moveMaelstrom() {
        // Moving maelstrom 1 space south and 2 spaces east OR when space runs out, to the edge.
        // Determining new maelstrom location

        Coordinate newMaelstromLocation;
        if (currentLocation.row < boardHeight - 1 && currentLocation.column < boardWidth - 2) {
            newMaelstromLocation = new Coordinate(currentLocation.row + 1, currentLocation.column + 2);
        } else if (currentLocation.row < boardHeight - 1 && currentLocation.column < boardWidth - 1) {
            newMaelstromLocation = new Coordinate(currentLocation.row + 1, currentLocation.column + 1);
        } else if (currentLocation.row < boardHeight - 1 && currentLocation.column == boardWidth - 1) {
            newMaelstromLocation = new Coordinate(currentLocation.row + 1, currentLocation.column);
        } else if (currentLocation.row == boardHeight - 1 && currentLocation.column < boardWidth - 2) {
            newMaelstromLocation = new Coordinate(currentLocation.row, currentLocation.column + 2);
        } else if (currentLocation.row == boardHeight - 1 && currentLocation.column < boardWidth - 1) {
            newMaelstromLocation = new Coordinate(currentLocation.row, currentLocation.column + 1);
        } else if (currentLocation.row == boardHeight - 1 && currentLocation.column == boardWidth - 1) {
            newMaelstromLocation = new Coordinate(currentLocation.row, currentLocation.column);
        } else {
            newMaelstromLocation = new Coordinate(currentLocation.row, currentLocation.column);
            System.out.println("How strange, the maelstrom hasn't moved.");
        }

        // Setting new maelstrom location
        for (int i = 0; i < this.boardHeight; i++) {
            for (int j = 0; j < this.boardWidth; j++) {
                if (this.board[i][j].roomLocation().equals(newMaelstromLocation)) {
                    this.board[i][j].setHasMaelstrom(true);
                }
            }
        }
    }

    public void movePlayerByMaelstrom() {
        // Moving player 1 space north and 2 spaces east
        // Determining new player location
        Coordinate newPlayerLocation;

        if (currentLocation.row > 0 && currentLocation.column < boardWidth) {
            newPlayerLocation = new Coordinate(currentLocation.row - 1, currentLocation.column + 2);
        } else if (currentLocation.row > 0 && currentLocation.column < boardWidth - 1) {
            newPlayerLocation = new Coordinate(currentLocation.row - 1, currentLocation.column + 1);
        } else if (currentLocation.row > 0 && currentLocation.column == boardWidth - 1) {
            newPlayerLocation = new Coordinate(currentLocation.row - 1, currentLocation.column);
        } else if (currentLocation.row == 0 && currentLocation.column < boardWidth) {
            newPlayerLocation = new Coordinate(currentLocation.row, currentLocation.column + 2);
        } else if (currentLocation.row == 0 && currentLocation.column < boardWidth - 1) {
            newPlayerLocation = new Coordinate(currentLocation.row, currentLocation.column + 1);
        } else if (currentLocation.row == 0 && currentLocation.column == boardWidth - 1) {
            newPlayerLocation = new Coordinate(currentLocation.row, currentLocation.column);
        } else {
            newPlayerLocation = new Coordinate(currentLocation.row, currentLocation.column);
        }

        // Setting new player location
        currentLocation = newPlayerLocation;
    }

    public void displayBoardSecrets() {
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                Room room = board[i][j];
                if (room.roomLocation().equals(currentLocation)) {
                    System.out.print("X "); // Current location
                } else if (room.isFountain()) {
                    System.out.print("F "); // Fountain room
                } else if (room.isEntrance()) {
                    System.out.print("E "); // Entrance room
                } else if (room.isPit()) {
                    System.out.print("P "); // Pit room
                } else if (room.hasMaelstrom()) {
                    System.out.print("M "); // Room with maelstrom
                } else if (room.hasAmarok()) {
                    System.out.print("A "); // Amarok room
                } else {
                    System.out.print(". "); // Empty room
                }
            }
            System.out.println(); // Move to next row
        }
    } // Displaying board with all secrets. Not used in game!

    public void displayBoard() {

        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                Room room = board[i][j];
                if (room.roomLocation().isMatchWith(currentLocation)) {
                    System.out.print("[X] "); // Current location
                } else {
                    System.out.print("[ ] "); // Empty room
                }
            }
            System.out.println(); // Move to next row
        }
    }

    // Shooting
    public void shoot(Direction direction) {
        // Check if the player has enough ammo
        if (playerAmmo <= 0) {
            System.out.println(ANSI_RED + "You are out of arrows!" + ANSI_RESET);
            return;
        }

        // Check for a room in the specified direction
        boolean isValidDirection = false;

        switch (direction) {
            case NORTH -> {
                if (currentRoom.roomLocation().row != 0) isValidDirection = true;
            }
            case SOUTH -> {
                if (currentRoom.roomLocation().row < boardHeight - 1) isValidDirection = true;
            }
            case WEST -> {
                if (currentRoom.roomLocation().column != 0) isValidDirection = true;
            }
            case EAST -> {
                if (currentRoom.roomLocation().column < boardWidth - 1) isValidDirection = true;
            }
        }
        if (!isValidDirection) {
            System.out.println(ANSI_RED + "There's no room to the north." + ANSI_RESET);
        }

        // Define target room
        Room targetRoom = null;
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                if (board[i][j].roomLocation().isMatchWith(currentLocation)) {
                    switch (direction) {
                        case NORTH -> targetRoom = board[i - 1][j];
                        case SOUTH -> targetRoom = board[i + 1][j];
                        case WEST -> targetRoom = board[i][j - 1];
                        case EAST -> targetRoom = board[i][j + 1];
                    }
                }
            }
        }

        // Checking for special rooms
        assert targetRoom != null;
        if (targetRoom.hasAmarok) {
            System.out.println(ANSI_GREEN + "You shot and killed an Amarok!" + ANSI_RESET);
            targetRoom.setHasAmarok(false);
        } else if (targetRoom.hasMaelstrom) {
            System.out.println(ANSI_GREEN + "You shot and killed a Maelstrom!" + ANSI_RESET);
            targetRoom.setHasMaelstrom(false);
        } else {
            System.out.println(ANSI_RED + "There was no monster in the room to the north." + ANSI_RESET);
        }

        // Reducing player Ammo
        playerAmmo -= 1;
    }
}
