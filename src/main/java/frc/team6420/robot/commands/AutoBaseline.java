package frc.team6420.robot.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.team6420.robot.Robot;


public class AutoBaseline extends TimedCommand {

    public AutoBaseline() {
    	super(4.25); //waits 4.25 seconds
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.driveBase.driveArcadeAuto(-0.5, 0);
    }

    protected void end() {
    	Robot.driveBase.driveArcadeAuto(0, 0);
    }

    protected void interrupted() {
    }
}
