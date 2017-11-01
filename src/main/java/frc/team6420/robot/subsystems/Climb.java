package frc.team6420.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

import frc.team6420.robot.commands.DriveWithJoystick;

public class Climb extends Subsystem {
	private SpeedController climber;

	public Climb( SpeedController climber ){
		this.climber = climber;
	}
	public void setPower( Double power ){
		climber.set( power );
	}

    public void initDefaultCommand() {
    	setDefaultCommand( new DriveWithJoystick() );
    }
}

