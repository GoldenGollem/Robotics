package org.usfirst.frc2509.Robot;

import org.usfirst.frc2509.Robot.commands.AutonomousCommand;
import org.usfirst.frc2509.Robot.subsystems.ArmMotors;
import org.usfirst.frc2509.Robot.subsystems.ArmPiston;
import org.usfirst.frc2509.Robot.subsystems.Grip;
import org.usfirst.frc2509.Robot.subsystems.Guide;
import org.usfirst.frc2509.Robot.subsystems.Lift;
import org.usfirst.frc2509.Robot.subsystems.RobotDrive;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {
	//Autonomous Variables
	SendableChooser chooser;
	final String defaultAuto = "Default";
    final String customAuto = "My Auto";
    String autoSelected;
    Command autonomousCommand;
    //Subsytem Variables
    public static OI oi;
    public static ArmMotors armMotor;
    public static ArmPiston armPiston;
    public static Compressor comp;
    public static Grip grip;
    public static Guide guide;
    public static Lift lift;
    public static RobotDrive robotDrive;    
    //Joystick Variables
    public Joystick leftStick;
    public Joystick rightStick;


    public void robotInit() {
    	RobotMap.init();
        robotDrive = new RobotDrive();
        grip = new Grip();
        guide = new Guide();
        lift = new Lift();
        armPiston = new ArmPiston();
        armMotor = new ArmMotors();
        
        /**
         * OI must be constructed after subsystems. If the OI creates Commands
         * (which it very likely will), subsystems are not guaranteed to be
         * constructed yet. Thus, their requires() statements may grab null
         * pointers. Bad news. Don't move it.
         */
        
        oi = new OI();
        
        leftStick = Robot.oi.lStick;
        rightStick = Robot.oi.rStick;
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", defaultAuto);
        chooser.addObject("My Auto", customAuto);
        SmartDashboard.putData("Auto choices", chooser);
    }

    public void disabledInit(){

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
    	autoSelected = (String) chooser.getSelected();
//		autoSelected = SmartDashboard.getString("Auto Selector", defaultAuto);
		System.out.println("Auto selected: " + autoSelected);
		switch(autoSelected) {
    	case customAuto:
        	   
            break;
    	case defaultAuto:
    	default:
    		autonomousCommand = new AutonomousCommand();
            break;
    	}
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    public void teleopPeriodic() {
        while(isEnabled()&&isOperatorControl()){
        	Scheduler.getInstance().run();
        	Robot.robotDrive.OpControl(leftStick, rightStick);
        	Robot.oi.CheckDigital();
        }
    }

    public void testPeriodic() {
        LiveWindow.run();
    }
}
