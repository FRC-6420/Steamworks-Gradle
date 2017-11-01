package frc.team6420.robot;

import frc.team6420.robot.commands.*;
import frc.team6420.robot.subsystems.Shifter.Gear;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    private Joystick joystick;

    public OI() {
        joystick = new Joystick(0);

        Button shiftButton = new JoystickButton(joystick, 1 );
        shiftButton.whenPressed( new ShiftCommand( Gear.HIGH ) );
        shiftButton.whenReleased( new ShiftCommand( Gear.LOW ) );

        Button cameraButton = new JoystickButton(joystick, 2 );
        cameraButton.whenPressed( new CameraCommand( true ) );
        cameraButton.whenReleased( new CameraCommand( false ) );

        Button gearButton = new JoystickButton(joystick, 3 );
        gearButton.toggleWhenPressed( new DropGear() );

        Button eStopbutton = new JoystickButton(joystick, 11 );
        eStopbutton.toggleWhenPressed( new StopClimb() );
    }

    public Joystick getJoystick() {
        return joystick;
    }

}