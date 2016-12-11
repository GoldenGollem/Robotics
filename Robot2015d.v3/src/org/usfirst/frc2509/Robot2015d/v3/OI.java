package org.usfirst.frc2509.Robot2015d.v3;

import org.usfirst.frc2509.Robot2015d.v3.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc2509.Robot2015d.v3.subsystems.*;

public class OI {

	/**
	 * TRIGGERING COMMANDS WITH BUTTONS
	 * Once you have a button, it's trivial to bind it to a button in one of
	 * three ways:
	 * 
	 * Start the command when the button is pressed and let it run the command
	 * until it is finished as determined by it's isFinished method.
	 * button.whenPressed(new ExampleCommand());
	 * 
	 * Run the command while the button is being held down and interrupt it once
	 * the button is released.
	 * button.whileHeld(new ExampleCommand());
	 * 
	 * Start the command when the button is released  and let it run the command
	 * until it is finished as determined by it's isFinished method.
	 * button.whenReleased(new ExampleCommand());
	 */
	
    public JoystickButton arm_A;
    public JoystickButton arm_B;
    public JoystickButton grip;
    public JoystickButton guide;
    public JoystickButton lift_Up;
    public JoystickButton lift_Down;
    
    public Joystick rStick;
    public Joystick lStick;

    public OI() {
    	lStick = new Joystick(0);
        rStick = new Joystick(1);
        
        grip = new JoystickButton(rStick, 1);
        grip.whenPressed(new MoveGrip());
        lift_Down = new JoystickButton(rStick, 2);
        lift_Down.whileHeld(new LiftDown());
        lift_Up = new JoystickButton(rStick, 3);
        lift_Up.whileHeld(new LiftUp());
        guide = new JoystickButton(lStick, 4);
        guide.whenPressed(new MoveGuide());
        arm_B = new JoystickButton(lStick, 1);
        arm_B.whenReleased(new ArmOut());
        arm_A = new JoystickButton(lStick, 1);
        arm_A.whileHeld(new ArmIn());


        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("GripIn", new GripIn());
        SmartDashboard.putData("GripOut", new GripOut());
        SmartDashboard.putData("GuideIn", new GuideIn());
        SmartDashboard.putData("GuideOff", new GuideOff());
        SmartDashboard.putData("ArmIn", new ArmIn());
        SmartDashboard.putData("ArmOut", new ArmOut());
        SmartDashboard.putData("LiftUp", new LiftUp());
        SmartDashboard.putData("LiftDown", new LiftDown());
        SmartDashboard.putData("MoveGrip", new MoveGrip());
        SmartDashboard.putData("MoveGuide", new MoveGuide());

    }

    public Joystick getlStick() {
        return lStick;
    }

    public Joystick getrStick() {
        return rStick;
    }
    public void CheckDigital(){
    	SmartDashboard.putBoolean("Top Left", RobotMap.leftTop.get());
    	SmartDashboard.putBoolean("Top Right", RobotMap.rightTop.get());
    	SmartDashboard.putBoolean("Bottom Left", RobotMap.leftBottom.get());
    	SmartDashboard.putBoolean("Bottom Right", RobotMap.rightBottom.get());
    }
}

