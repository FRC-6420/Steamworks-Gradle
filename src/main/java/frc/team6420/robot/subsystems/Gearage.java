package frc.team6420.robot.subsystems;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gearage extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	DoubleSolenoid gearDrop;

	public Gearage( DoubleSolenoid gearDrop ){
		this.gearDrop = gearDrop;
	}
	
	public void open(){
		gearDrop.set( DoubleSolenoid.Value.kReverse );
	}
	
	public void close(){
		gearDrop.set( DoubleSolenoid.Value.kForward );
	}

	@Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

