package org.usfirst.frc2509.Robot;

import org.usfirst.frc2509.Robot.commands.ArmIn;
import org.usfirst.frc2509.Robot.commands.ArmMove;
import org.usfirst.frc2509.Robot.commands.ArmOut;
import org.usfirst.frc2509.Robot.commands.AutonomousCommand;
import org.usfirst.frc2509.Robot.commands.GripIn;
import org.usfirst.frc2509.Robot.commands.GripOut;
import org.usfirst.frc2509.Robot.commands.GuideIn;
import org.usfirst.frc2509.Robot.commands.GuideOff;
import org.usfirst.frc2509.Robot.commands.LiftDown;
import org.usfirst.frc2509.Robot.commands.LiftUp;
import org.usfirst.frc2509.Robot.commands.MoveGrip;
import org.usfirst.frc2509.Robot.commands.MoveGuide;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	//Joystick Buttons
    public JoystickButton arm_A;
  //public JoystickButton arm_B;
    public JoystickButton grip;
    public JoystickButton guide;
    public JoystickButton lift_Up;
    public JoystickButton lift_Down;
    //Joysticks
    public Joystick rStick;
    public Joystick lStick;

    public OI() {
    	//Define Joystick Variables
    	lStick = new Joystick(0);
        rStick = new Joystick(1);
        //Define Joystick Buttons
        grip = new JoystickButton(rStick, 1);
        grip.whenPressed(new MoveGrip());
        lift_Down = new JoystickButton(rStick, 2);
        lift_Down.whileHeld(new LiftDown());
        lift_Up = new JoystickButton(rStick, 3);
        lift_Up.whileHeld(new LiftUp());
        guide = new JoystickButton(lStick, 4);
        guide.whenPressed(new MoveGuide());
        //arm_B = new JoystickButton(lStick, 1);
        //arm_B.whenReleased(new ArmOut());
        arm_A = new JoystickButton(lStick, 1);
        arm_A.whileHeld(new ArmMove());


        // SMARTDASHBOARD BUTTONS
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("Arm In", new ArmIn());
        SmartDashboard.putData("Arm Out", new ArmOut());
        SmartDashboard.putData("Grip In", new GripIn());
        SmartDashboard.putData("Grip Out", new GripOut());
        SmartDashboard.putData("Guide In", new GuideIn());
        SmartDashboard.putData("Guide Off", new GuideOff());
        SmartDashboard.putData("Lift Up", new LiftUp());
        SmartDashboard.putData("Lift Down", new LiftDown());
        SmartDashboard.putData("Move Grip", new MoveGrip());
        SmartDashboard.putData("Move Guide", new MoveGuide());
        SmartDashboard.putData("Move Arm", new ArmMove());
    }

    public Joystick getlStick() {
        return lStick;
    }

    public Joystick getrStick() {
        return rStick;
    }
    
    /**
     * This when called will display the limit switch values
     * on to the SmartDashboard. To get constant display run
     * this in the teleopPeriodic()
     */
    public void CheckDigital(){
    	SmartDashboard.putBoolean("Top Left", RobotMap.leftTop.get());
    	SmartDashboard.putBoolean("Top Right", RobotMap.rightTop.get());
    	SmartDashboard.putBoolean("Bottom Left", RobotMap.leftBottom.get());
    	SmartDashboard.putBoolean("Bottom Right", RobotMap.rightBottom.get());
    }
}

