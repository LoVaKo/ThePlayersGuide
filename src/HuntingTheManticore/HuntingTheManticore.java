package HuntingTheManticore;

import java.util.Scanner;

public class HuntingTheManticore {
    public static Scanner scanner = new Scanner(System.in);
    int manticoreHealth = 10;
    int cityHealth = 10;
    int manticoreDistance;
    int round = 1;
    int damage = 0;
    String user1;
    String user2;

    public HuntingTheManticore() {
        System.out.println("The Uncoded One’s airship, the Manticore, has begun an all-out attack on the city of Consolas. \n" +
                "It must be destroyed, or the city will fall. Will you defend the city or join the Uncoded One?");
        System.out.println();

        // Naming the users
        System.out.println("User 1, join the dark side: please enter your name");
        user1 = scanner.next();
        System.out.println();
        System.out.println("User 2, defend the city: please enter your name");
        user2 = scanner.next();
        System.out.println();

        clearConsole();
        this.placeManticore();

        System.out.println("""
                                       .|
                                       | |
                                       |'|            ._____
                               ___    |  |            |.   |' .---"|
                       _    .-'   '-. |  |     .--'|  ||   | _|    |
                    .-'|  _.|  |    ||   '-__  |   |  |    ||      |
                    |' | |.    |    ||       | |   |  |    ||      |
                 ___|  '-'     '    ""       '-'   '-.'    '`      |____
                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~""");
        System.out.println();
        System.out.println(user2 + ", the Manticore has taken position. \n" +
                "But because it's using an invisibility shield, it could be anywhere between 0 - 100 miles from here.\n" +
                "Luckily, the missiles used in the cannon you're operating send you direct feedback when you miss your target.\n" +
                "Act accordingly, and destroy the Manticore before it destroys the entire City of Consolas!" +
                "Press ENTER to start.");
        scanner.nextLine();
        System.out.println();
    }

    public static void main(String[] args) {
        // Setting up the game
        printTitleScreen();
        clearConsole();
        HuntingTheManticore game = new HuntingTheManticore();

        // Game loop
        while (game.manticoreHealth > 0 && game.cityHealth > 0) {
            game.damage = calculateDamage(game.round);
            game.statusReport();

            System.out.println("Enter desired cannon range:");
            if (scanner.hasNextInt()) {
                int cannonRange = scanner.nextInt();
                scanner.nextLine();

                if (cannonRange < game.manticoreDistance) {
                    System.out.println();
                    System.out.println("\u001B[31mThat round fell short of the target.\u001B[0m");
                    System.out.println();
                } else if (cannonRange > game.manticoreDistance) {
                    System.out.println();
                    System.out.println("\u001B[31mThat round overshot the target.\u001B[0m");
                    System.out.println();
                } else {
                    System.out.println();
                    System.out.println("\u001B[32mThat round was a direct hit!\u001B[0m");
                    System.out.println();
                    game.manticoreHealth = game.manticoreHealth - game.damage;
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            game.round++;
            game.cityHealth--;
            if (game.manticoreHealth > 0 && game.cityHealth > 0) {
                System.out.println("Are you ready for your next attack? Press Enter.");
                scanner.nextLine();
            }
        }

        // Conclusion of the game
        if (game.manticoreHealth <= 0 && game.cityHealth > 0) {
            System.out.println("""
                                                           .
                                  . .                     -:-             .  .  .
                                .'.:,'.        .  .  .     ' .           . \\ | / .
                                .'.;.`.       ._. ! ._.       \\          .__\\:/__.
                                 `,:.'         ._\\!/_.                     .';`.      . ' .
                                 ,'             . ! .        ,.,      ..======..       .:.
                                ,                 .         ._!_.     ||::: : | .        ',
                         .====.,                  .           ;  .~.===: : : :|   ..===.
                         |.::'||      .=====.,    ..=======.~,   |"|: :|::::::|   ||:::|=====|
                      ___| :::|!__.,  |:::::|!_,   |: :: ::|"|l_l|"|:: |:;;:::|___!| ::|: : :|
                     |: :|::: |:: |!__|; :: |: |===::: :: :|"||_||"| : |: :: :|: : |:: |:::::|
                     |:::| _::|: :|:::|:===:|::|:::|:===F=:|"!/|\\!"|::F|:====:|::_:|: :|::__:|
                     !_[]![_]_!_[]![]_!_[__]![]![_]![_][I_]!//_:_\\\\![]I![_][_]!_[_]![]_!_[__]!
                     -----------------------------------"---''''```---"-----------------------
                     _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |= _ _:_ _ =| _ _ _ _ _ _ _ _ _ _ _ _
                                                         |=    :    =|                       \s
                    _____________________________________L___________J________________________
                    --------------------------------------------------------------------------""");
            System.out.println("The Manticore has been destroyed!");
            System.out.println(game.user2 + " has won the game.");
        } else if (game.manticoreHealth > 0) {
            System.out.println("""
                                      _  /)
                                     mo / )
                                     |/)\\)
                                      /\\_
                                      \\__|=
                                     (    )
                                     __)(__
                               _____/      \\\\_____
                              |  _     ___   _   ||
                              | | \\     |   | \\  ||
                              | |  |    |   |  | ||
                              | |_/     |   |_/  ||
                              | | \\     |   |    ||
                              | |  \\    |   |    ||
                              | |   \\. _|_. | .  ||
                              |                  ||
                              |                  ||
                              |                  ||
                      *       | *   **    * **   |**      **
                       \\))..,,.,/.,(//,,..,,\\||(,,.,\\\\,.((//\
                    """);
            System.out.println("The City of Consolas has been destroyed!");
            System.out.println(game.user1 + " has won the game.");
        } else {
            System.out.println("Both the Manticore and the City have been destroyed!");
            System.out.println("Everybody loses!");
        }
    }

    private static int calculateDamage(int round) {
        if (round % 3 != 0 && round % 5 != 0) {
            return 1;
        } else if (round % 3 == 0 && round % 5 != 0) {
            return 3;
        } else if (round % 3 != 0) {
            return 3;
        } else {
            return 5;
        }
    }

    private static void clearConsole() {
        for (int i = 0; i < 40; i++) {
            System.out.println("\n");
        }
    }

    private static void printTitleScreen() {
        System.out.println("""
                                                                                                                                                                  \s
                888888888888  88                          88b           d88                                   88                                                  \s
                     88       88                          888b         d888                            ,d     ""                                                  \s
                     88       88                          88`8b       d8'88                            88                                                         \s
                     88       88,dPPYba,    ,adPPYba,     88 `8b     d8' 88  ,adPPYYba,  8b,dPPYba,  MM88MMM  88   ,adPPYba,   ,adPPYba,   8b,dPPYba,   ,adPPYba, \s
                     88       88P'    "8a  a8P_____88     88  `8b   d8'  88  ""     `Y8  88P'   `"8a   88     88  a8"     ""  a8"     "8a  88P'   "Y8  a8P_____88 \s
                     88       88       88  8PP""\"""\""     88   `8b d8'   88  ,adPPPPP88  88       88   88     88  8b          8b       d8  88          8PP""\"""\"" \s
                     88       88       88  "8b,   ,aa     88    `888'    88  88,    ,88  88       88   88,    88  "8a,   ,aa  "8a,   ,a8"  88          "8b,   ,aa \s
                     88       88       88   `"Ybbd8"'     88     `8'     88  `"8bbdP"Y8  88       88   "Y888  88   `"Ybbd8"'   `"YbbdP"'   88           `"Ybbd8"' \s
                                                                                                                                                                  \s
                                                                                                                                                                  \s""");
        System.out.println("""
                                                   /\\_|__|_ _  _|    _  _   _|_|_  _    _._|_    _  |`   _ _  _  _ _ | _  _
                                                  /~~\\|  | (_|(_|<  (_)| |   | | |(/_  (_| |\\/  (_)~|~  (_(_)| |_\\(_)|(_|_\\
                                                                                            /                              \
                """);
        System.out.println(
                """
                                                                      _____                     ______       _           \s
                                                                    |  __ \\                   |  ____|     | |          \s
                                                                    | |__) | __ ___  ___ ___  | |__   _ __ | |_ ___ _ __\s
                                                                    |  ___/ '__/ _ \\/ __/ __| |  __| | '_ \\| __/ _ \\ '__|
                                                                    | |   | | |  __/\\__ \\__ \\ | |____| | | | ||  __/ |  \s
                                                                    |_|   |_|  \\___||___/___/ |______|_| |_|\\__\\___|_|  \s
                                                                             \s
                                                                              \
                        """);
        scanner.nextLine();
    }

    private void statusReport() {
        System.out.println("\u001B[34mSTATUS REPORT\n" +
                "Round number: " + round + "\n" +
                "City health: " + cityHealth + "/15\n" +
                "Manticore health: " + manticoreHealth + "/10\n" +
                "The cannon is expected to deal " + damage + " damage the next round.\u001B[0m");
        System.out.println();
    }

    private void placeManticore() {
        System.out.println("""
                                     `. ___
                                    __,' __`.                _..----....____
                        __...--.'``;.   ,.   ;``--..__     .'    ,-._    _.-'
                  _..-''-------'   `'   `'   `'     O ``-''._   (,;') _,'
                ,'________________                          \\`-._`-','
                 `._              ```````````------...___   '-.._'-:
                    ```--.._      ,.                     ````--...__\\-.
                            `.--. `-`                       ____    |  |`
                              `. `.                       ,'`````.  ;  ;`
                                `._`.        __________   `.      \\'__/`
                                   `-:._____/______/___/____`.     \\  `
                                               |       `._    `.    \\
                                               `._________`-.   `.   `.___
                                                                  `------'`""");
        int targetNumber = -1;
        do {
            System.out.println(user1 + ", you're the pilot of the Manticore. How far away from the city do you want to station the aircraft and start your attack?");
            System.out.println("Choose a number between 0 and 100");
            if (scanner.hasNextInt()) {
                targetNumber = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number between 0 and 100.");
                scanner.nextLine();
            }
        }
        while (targetNumber < 1 || targetNumber > 99);
        this.manticoreDistance = targetNumber;
        clearConsole();
    }

}
