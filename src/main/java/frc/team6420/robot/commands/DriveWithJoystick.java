package frc.team6420.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import frc.team6420.robot.Robot;

/**
 *
 */
public class DriveWithJoystick extends Command {

    public DriveWithJoystick() {
        requires(Robot.driveBase);
        requires(Robot.climber);

        this.setInterruptible( true );
    }

    protected void execute() {
    	//Robot.driveBase.driveArcade( Robot.oi.fancyStick );
    	double x = Robot.oi.getJoystick().getX();
    	if( Math.abs( x ) < 0.1 ) {
    		x = 0;
    	}
    	Robot.driveBase.driveArcade( Robot.oi.getJoystick().getY(), -x );
    	double climb = Robot.oi.getJoystick().getThrottle();
    	//climb = (-climb + 1) * 0.5;
    	if( Math.abs( climb ) < 0.25 ){
    		climb = 0;
    	}
    	Robot.climber.setPower( climb );
    }

    protected boolean isFinished() {
        return false;
    }
}
