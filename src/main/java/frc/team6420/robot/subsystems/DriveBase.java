package frc.team6420.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.team6420.robot.commands.DriveWithJoystick;

public class DriveBase extends PIDSubsystem {

    private final DifferentialDrive driveBaseController;
    private final ADXRS450_Gyro gyro;
    private final Encoder leftEncoder;
    private final Encoder rightEncoder;
    private double offset;
    private final AnalogInput us;
    private final int[] values = new int[5];
    private double movementPower = 0;
    private final double powerIncrement = 0.05;
    
    public DriveBase( DifferentialDrive driveBase, ADXRS450_Gyro gyro, Encoder leftEncoder, Encoder rightEncoder, AnalogInput ultrasonic ){
    	super( 0.1, 0, 0 );
    	this.setSetpointRelative( 0.0 );
        driveBaseController = driveBase;
        this.gyro = gyro;
        this.leftEncoder = leftEncoder;
        this.rightEncoder = rightEncoder;
        us = ultrasonic;
    }
    
    public void driveArcade( double movementValue, double turnValue ){
    	double diff = Math.abs( Math.abs( movementValue ) - Math.abs( movementPower ) );
    	if( Math.abs( movementValue ) < 0.05 ){
    		movementValue = 0;
    	}
    	if( diff < powerIncrement ){
    		movementPower = movementValue;
    	}else{
    		if( movementPower > movementValue ){
    			movementPower -= powerIncrement;
    		}else{
    			movementPower += powerIncrement;
    		}
    	}
    	if( Math.abs( turnValue ) < 0.1 ){
    		driveBaseController.arcadeDrive( movementPower, offset );
    	}else{
    		this.setSetpoint( offset );
    		driveBaseController.arcadeDrive( movementPower, turnValue );
    	}
    }
    
    public void driveArcadeAuto( double movementValue, double turnValue ){
    	movementPower = movementValue;
    	if( Math.abs( turnValue ) < 0.1 ){
    		driveBaseController.arcadeDrive( movementPower, offset );
    	}else{
    		this.setSetpoint( offset );
    		driveBaseController.arcadeDrive( movementPower, turnValue );
    	}
    }
    
    public void stop(){
    	movementPower = 0;
    	driveArcade( 0, 0 );
    }
 
    
    public double getAngle(){
    	return gyro.getAngle();
    }
    
    public double getAverageEncoderCount(){
    	return (rightEncoder.get() + leftEncoder.get()) * 0.5;
    }

    public void initDefaultCommand() {

        setDefaultCommand(new DriveWithJoystick());
    }

	@Override
	protected double returnPIDInput() {
		// return the difference in encoder counts from right to left (left will be negative)
		return rightEncoder.get() - leftEncoder.get();
	}

	@Override
	protected void usePIDOutput(double output) {
		offset = output;
	}
	
	public int getUltrasonicLevel(){
		int[] filter = new int[5];
		for( int i = 0; i < 4; i++ ){
			values[i+1] = values[i];
			filter[i+1] = values[i];
		}
		values[0] = us.getValue();
		filter[0] = values[0];
		//low pass
		int lowIndex = 0;
		for( int i = 1; i<5; i++ ){
			if( values[ lowIndex ] > values[ i ] ){
				lowIndex = i;
			}
		}
		values[ lowIndex ] = 0;
		int sum = 0;
		for( int i : values ) sum+= i;
		return sum / 4;
	}
}

