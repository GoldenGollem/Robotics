package org.usfirst.frc.team2509.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    Joystick leftStick;
    public Joystick rightStick;
    public OI() {
        leftStick = new Joystick(0);
        rightStick = new Joystick(1);
    }
    public Joystick getleftStick() {
        return leftStick;
    }
    public Joystick getrightStick(){
    	return rightStick;
    }
}

