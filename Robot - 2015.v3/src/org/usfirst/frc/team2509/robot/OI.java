package org.usfirst.frc.team2509.robot;

import org.usfirst.frc.team2509.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    public Joystick leftStick;
    public Joystick rightStick;
    public JoystickButton Guide;
    public JoystickButton GripIn;
    public JoystickButton GripOff;
    public OI() {
        leftStick = new Joystick(0);
        rightStick = new Joystick(1);
        //Define Guide Buttons
        Guide = new JoystickButton(rightStick, 2);
        Guide.whileHeld(new GuideIn());
        Guide.whenReleased(new GuideOff());
        //Define Grip Buttons
        GripIn = new JoystickButton(leftStick, 1);
        GripIn.whenPressed(new GripIn());
        GripOff = new JoystickButton(leftStick, 2);
        GripOff.whenPressed(new GripOff());
    }
    public Joystick getleftStick() {
        return leftStick;
    }
    public Joystick getrightStick(){
    	return rightStick;
    }
}

