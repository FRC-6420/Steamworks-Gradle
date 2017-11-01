package frc.team6420.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import frc.team6420.robot.Robot;

public class AutoMoveUltrasonic extends Command {
	private int target;
    public AutoMoveUltrasonic( int target ) {
    	this.target = target;
    	requires( Robot.driveBase );
    }

    protected void execute() {
    	Robot.driveBase.driveArcade( 0.5, 0.0 );
    }

    protected boolean isFinished() {
        return Robot.driveBase.getUltrasonicLevel() < target;
    }

    protected void end() {
    	Robot.driveBase.driveArcade( 0, 0 );
    }

}
