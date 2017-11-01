package frc.team6420.robot.commands;

import frc.team6420.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class CameraCommand extends InstantCommand {
	private boolean enable;
    public CameraCommand( boolean enabled ) {
    	enable = enabled;
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.vision.setLEDs( enable );
    }

}
