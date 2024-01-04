package TPG34;

public class OffCommand implements RobotCommand {

    public void run(Robot robot) {
        robot.turnOff();
    }
}