package frc.team6420.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team6420.robot.commands.*;
import frc.team6420.robot.subsystems.*;

public class Robot extends IterativeRobot {

    private Command autonomousCommand;

    public static OI oi;
    public static Vision vision;
    public static Gearage gearage;
    public static Shifter shifter;
    public static Climb climber;
    public static RIODuino ledcontroller;
    public static Selector selector;
    public static DriveBase driveBase;
    private static RobotMap robotMap;

    @Override
    public void robotInit() {
        robotMap = new RobotMap();
        vision = new Vision( robotMap.getVisionLEDs() );
        gearage = new Gearage( robotMap.getGearDrop() );
        shifter = new Shifter( robotMap.getShift() );
        climber = new Climb( robotMap.getClimber() );
        ledcontroller = new RIODuino( robotMap.getExpansionSerialPort() );
        selector = new Selector();
        driveBase = new DriveBase(
                robotMap.getDriveBase(),
                robotMap.getGyro(),
                robotMap.getLeftDriveEncoder(),
                robotMap.getRightDriveEncoder(),
                robotMap.getUltrasonicSensor()
        );

        oi = new OI();

        selector.addCommand( robotMap.getDio5(), new AutoLeft() );
        selector.addCommand( robotMap.getDio6(), new AutoCenter() );
        selector.addCommand( robotMap.getDio7(), new AutoRight() );
    }

    @Override
    public void autonomousInit() {
        if(DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Red ){
            Robot.ledcontroller.setMode( RIODuino.Mode.PULSE_RED );
        }else{
            Robot.ledcontroller.setMode( RIODuino.Mode.PULSE_BLUE );
        }
        autonomousCommand = selector.getSelected();
        if( autonomousCommand == null ){
            autonomousCommand = new AutoBaseline();
        }
        gearage.close();
        autonomousCommand.start();
    }

    @Override
    public void teleopInit() {
        if( DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Red ){
            Robot.ledcontroller.setMode( RIODuino.Mode.MOVING_RED );
        }else{
            Robot.ledcontroller.setMode( RIODuino.Mode.MOVING_BLUE );
        }
        if(autonomousCommand != null) autonomousCommand.cancel();
        gearage.close();
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

}