package frc.team6420.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class AutoRight extends CommandGroup {

    public AutoRight() {
    	addSequential( new AutoMove( 440, 0.8 ) );
    	
    	addSequential( new AutoTurn( -55 ) );
    	
    	addSequential( new AutoMove( 120 ), 3 );
    	
    	addParallel( new DropGear( 2 )  );
    	addSequential( new WaitCommand( 1 ) );
    	
    	addSequential( new AutoMove( -100 ) );
    	
    	addSequential( new AutoTurn( 60 ) );
    	
    	addSequential( new AutoMove( 500 ) );
    }
}
