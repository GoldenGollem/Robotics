package org.usfirst.frc.team2509.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {
    final String defaultAuto = "Default";
    final String customAuto = "My Auto";
    String autoSelected;
    SendableChooser chooser;
    DigitalInput TopLeft = new DigitalInput(2);
	DigitalInput TopRight = new DigitalInput(1);
	DigitalInput BotLeft = new DigitalInput(3);
	DigitalInput BotRight = new DigitalInput(0);
	Joystick stick1 = new Joystick(0);
	Joystick stick2 = new Joystick(1);
	SpeedController lMotor = new Talon(2);
	SpeedController rMotor = new Talon(1);
	RobotDrive chassis = new RobotDrive(lMotor, rMotor);

    public void robotInit() {
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", defaultAuto);
        chooser.addObject("My Auto", customAuto);
        SmartDashboard.putData("Auto choices", chooser);
        CheckDigital();
        lMotor.setInverted(true);
        rMotor.setInverted(true);
    	}
    public void autonomousInit() {
    	autoSelected = (String) chooser.getSelected();
		autoSelected = SmartDashboard.getString("Auto Selector", defaultAuto);
		System.out.println("Auto selected: " + autoSelected);
    }
    public void autonomousPeriodic() {
    	switch(autoSelected) {
    	case customAuto:
        //Put custom auto code here   
            break;
    	case defaultAuto:
    	default:
    	//Put default auto code here
            break;
    	}
    }

    public void teleopPeriodic() {
        while(isOperatorControl()&&isEnabled()){
        	CheckDigital();
        	chassis.tankDrive(stick1.getY(),stick2.getY());
        }
        
    }
    public void testPeriodic() {
    	LiveWindow.run();
    }
    public void CheckDigital(){
    	SmartDashboard.putBoolean("L Limit Top", TopLeft.get());
        SmartDashboard.putBoolean("L Limit Bottom", BotLeft.get());
        SmartDashboard.putBoolean("R Limit Top", TopRight.get());
        SmartDashboard.putBoolean("R Limit Bottom", BotRight.get());

    }
    
}
