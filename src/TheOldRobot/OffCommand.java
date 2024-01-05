package TheOldRobot;

public class OffCommand implements RobotCommand {

    public void run(Robot robot) {
        robot.turnOff();
    }
}