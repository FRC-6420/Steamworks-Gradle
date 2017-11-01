package frc.team6420.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.team6420.robot.Robot;
import frc.team6420.robot.subsystems.RIODuino;

public class setLEDMode extends InstantCommand {
	
	private RIODuino ledcontroller = Robot.ledcontroller;
	private RIODuino.Mode mode;

    public setLEDMode( RIODuino.Mode mode ) {
        super();
        this.mode = mode;
        requires( Robot.ledcontroller );
    }

    protected void initialize() {
    	ledcontroller.setMode( this.mode );
    }

}
