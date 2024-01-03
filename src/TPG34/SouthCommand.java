package TPG34;

public class SouthCommand implements RobotCommand{

    public void run(Robot robot) {
        if(robot.isPowered()) robot.moveSouth();
    }
}
