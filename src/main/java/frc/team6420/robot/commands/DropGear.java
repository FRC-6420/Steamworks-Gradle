package frc.team6420.robot.commands;

import frc.team6420.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

public class DropGear extends TimedCommand {
	private boolean isTimed = true;
	public DropGear(){
		super( 0 );
		isTimed = false;
	}
	public DropGear(double timeout ) {
		super(timeout);
		isTimed = true;
	}
    protected void initialize() {
    	Robot.gearage.open();
    }

	@Override
	protected boolean isFinished() {
		return isTimed && isTimedOut();
	}
	
	@Override
	protected void end(){
		Robot.gearage.close();
	}
}
