package frc.team6420.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;

import frc.team6420.robot.Robot;
import frc.team6420.robot.subsystems.Shifter;

public class ShiftCommand extends InstantCommand {
	private Shifter.Gear target;
	private Shifter shifter = Robot.shifter;

    public ShiftCommand( Shifter.Gear target ) {
        super();
        this.target = target;
        requires( Robot.shifter );
    }

    protected void initialize() {
    	shifter.shift( target );
    }
}
