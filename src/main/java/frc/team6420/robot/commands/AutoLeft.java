package frc.team6420.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutoLeft extends CommandGroup {

    public AutoLeft() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	
    	addSequential( new AutoMove( 440, 0.8 ) );
    	
    	addSequential( new AutoTurn( 60 ) );
    	
    	addSequential( new AutoMove( 120 ), 3 );
    	
    	addParallel( new DropGear( 2 ) );
    	addSequential( new WaitCommand( 1 ) );
    	
    	addSequential( new AutoMove( -100 ) );
    	
    	addSequential( new AutoTurn( -60 ) );
    	
    	addSequential( new AutoMove( 500 ) );

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
