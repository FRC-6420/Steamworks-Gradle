package frc.team6420.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shifter extends Subsystem {
    private final DoubleSolenoid shifter;
    private Gear shiftMode = Gear.LOW;

    public Shifter( DoubleSolenoid shifter ){
        this.shifter = shifter;
    }

	
    public void shift( Gear shift ){
    	shiftMode = shift;
    	shifter.set( shift.getDirection() );
    }
    
    public Gear getShiftMode(){
    	return shiftMode;
    }

    public void initDefaultCommand() {

    }
    
    public enum Gear {
    	LOW(DoubleSolenoid.Value.kForward),
    	HIGH(DoubleSolenoid.Value.kReverse);
    	
    	private DoubleSolenoid.Value direction;
    	
    	Gear(DoubleSolenoid.Value direction){
    		this.direction = direction;
    	}
    	public DoubleSolenoid.Value getDirection(){
    		return direction;
    	}
    }
}

