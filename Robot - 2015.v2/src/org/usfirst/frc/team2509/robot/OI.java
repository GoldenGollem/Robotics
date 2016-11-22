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
    public JoystickButton Grip;
    public OI() {
        leftStick = new Joystick(0);
        rightStick = new Joystick(1);
        //Define Grip Buttons
        Grip = new JoystickButton(rightStick, 2);
        Grip.whileHeld(new GripIn());
        Grip.whenReleased(new GripOff());
    }
    public Joystick getleftStick() {
        return leftStick;
    }
    public Joystick getrightStick(){
    	return rightStick;
    }
}

