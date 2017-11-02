package frc.team6420.robot;

import edu.wpi.first.wpilibj.*;

public class RobotMap {
    private SpeedController rightFront, leftFront, rightBack, leftBack;
    private RobotDrive driveBase;

    private DoubleSolenoid shift, gearDrop;
    private Encoder rightDriveEncoder, leftDriveEncoder;
    private ADXRS450_Gyro gyro;
    private AnalogInput ultrasonicSensor;
    private PowerDistributionPanel pdp;
    private Solenoid visionLEDs;
    private VictorSP climber;
    private DigitalInput dio6, dio7, dio5;
    private SerialPort expansionSerialPort;

    RobotMap(){
        rightFront = new VictorSP( 0 );
        rightBack = new VictorSP( 1 );
        leftFront = new VictorSP( 2 );
        leftBack = new VictorSP( 3 );

        driveBase = new RobotDrive( rightFront, rightBack, leftFront, leftBack );

        driveBase.setSafetyEnabled( true );
        driveBase.setExpiration( 0.5 );
        driveBase.setMaxOutput( 1.0 );

        dio6 = new DigitalInput( 6 );
        dio7 = new DigitalInput( 7 );
        dio5 = new DigitalInput( 5 );

        expansionSerialPort = new SerialPort( 9600, SerialPort.Port.kMXP );

        climber = new VictorSP( 4 );
        rightDriveEncoder = new Encoder( 0, 1 );
        leftDriveEncoder = new Encoder( 2, 3, true );
        shift = new DoubleSolenoid( 6, 7 );
        gearDrop = new DoubleSolenoid( 0, 1 );
        gyro = new ADXRS450_Gyro();
        ultrasonicSensor = new AnalogInput( 0 );
        pdp = new PowerDistributionPanel();
        visionLEDs = new Solenoid( 3 );
    }

    public DoubleSolenoid getShift() {
        return shift;
    }

    public DoubleSolenoid getGearDrop() {
        return gearDrop;
    }

    public Encoder getRightDriveEncoder() {
        return rightDriveEncoder;
    }

    public Encoder getLeftDriveEncoder() {
        return leftDriveEncoder;
    }

    public ADXRS450_Gyro getGyro() {
        return gyro;
    }

    public AnalogInput getUltrasonicSensor() {
        return ultrasonicSensor;
    }

    public PowerDistributionPanel getPdp() {
        return pdp;
    }

    public Solenoid getVisionLEDs() {
        return visionLEDs;
    }

    public VictorSP getClimber() {
        return climber;
    }

    public DigitalInput getDio6() {
        return dio6;
    }

    public DigitalInput getDio7() {
        return dio7;
    }

    public DigitalInput getDio5() {
        return dio5;
    }

    public RobotDrive getDriveBase() {
        return driveBase;
    }

    public SerialPort getExpansionSerialPort() {
        return expansionSerialPort;
    }
}
