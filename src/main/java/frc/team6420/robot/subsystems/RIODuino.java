package frc.team6420.robot.subsystems;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RIODuino extends Subsystem {
	
	private SerialPort spi; // = new SerialPort(9600, SerialPort.Port.kMXP );

	public RIODuino( SerialPort port ){
	    spi = port;
    }

	public void setMode( Mode mode ){
		spi.writeString( "" + (char)mode.ordinal() );
	}

    public void initDefaultCommand() {

    }
    
    public enum Mode{
    	PULSE_RED,
    	PULSE_GREEN,
    	PULSE_BLUE,
    	SOLID_RED,
    	SOLID_GREEN,
    	SOLID_BLUE,
    	MOVING_RED,
    	MOVING_GREEN,
    	MOVING_BLUE,
    }
}

