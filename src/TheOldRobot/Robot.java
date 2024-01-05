package TheOldRobot;

import java.util.ArrayList;
import java.util.Scanner;

public class Robot implements RobotCommand {
    private final ArrayList<RobotCommand> commands = new ArrayList<>();
    private int x;
    private int y;
    private boolean isPowered;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Robot robot = new Robot();
        boolean addCommand = true;

        while (addCommand) {
            String userInput = scanner.nextLine().toLowerCase();
            switch (userInput) {
                case "on":
                    robot.addCommand(new OnCommand());
                    break;
                case "off":
                    robot.addCommand(new OffCommand());
                    break;
                case "north":
                    robot.addCommand(new NorthCommand());
                    break;
                case "south":
                    robot.addCommand(new SouthCommand());
                    break;
                case "west":
                    robot.addCommand(new WestCommand());
                    break;
                case "east":
                    robot.addCommand(new EastCommand());
                    break;
                case "stop":
                    addCommand = false;
                    break;
                default:
                    System.out.println("Invalid input.");
            }
        }
        robot.run();
    }

    private void addCommand(RobotCommand newCommand) {
        commands.add(newCommand);
    }

    public void run() {
        for (RobotCommand command : commands) {
            command.run(this);
            System.out.printf("[%d %d %b]\n", x, y, isPowered);
        }
    }

    public void turnOn() {
        this.isPowered = true;
    }

    public void turnOff() {
        this.isPowered = false;
    }

    public boolean isPowered() {
        return this.isPowered;
    }

    public void moveNorth() {
        y++;
    }

    public void moveSouth() {
        y--;
    }

    public void moveWest() {
        x--;
    }

    public void moveEast() {
        x++;
    }

    @Override
    public void run(Robot robot) {

    }
}

