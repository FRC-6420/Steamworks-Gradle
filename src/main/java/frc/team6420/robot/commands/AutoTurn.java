package frc.team6420.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team6420.robot.Robot;
import frc.team6420.robot.subsystems.DriveBase;

/**
 *
 */
public class AutoTurn extends Command {
	private int target;
	private double absolute_target;
	private DriveBase driveBase = Robot.driveBase;

    public AutoTurn( int target ) {
        requires(Robot.driveBase);
		this.target = target;
	}

    protected void initialize() {
    	this.absolute_target = driveBase.getAngle() + target;
    }

    protected void execute() {
    	if( absolute_target - driveBase.getAngle() < 0 ){
    		driveBase.driveArcade( 0, 0.6 );
    	}else{
    		driveBase.driveArcade( 0, -0.6 );
    	}
    }

    protected boolean isFinished() {
    	return Math.abs( driveBase.getAngle() - this.absolute_target ) < 5;
    }

    protected void end() {
    	driveBase.driveArcade(0, 0);
    }

}
