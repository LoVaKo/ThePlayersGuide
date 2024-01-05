package TheOldRobot;

public class OnCommand implements RobotCommand {

    public void run(Robot robot) {
        robot.turnOn();
    }
}
