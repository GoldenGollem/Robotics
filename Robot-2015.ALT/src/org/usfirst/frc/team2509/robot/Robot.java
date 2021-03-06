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
	SpeedController robotDrivelMotor;
    SpeedController robotDriverMotor;
    RobotDrive robotDrive;
    Compressor comp;
    DoubleSolenoid gripPiston;
    DoubleSolenoid guidePiston;
    SpeedController liftlMotor;
    SpeedController liftrMotor;
    DoubleSolenoid armPiston;
    DigitalInput leftTop;
    DigitalInput rightTop;
    DigitalInput leftBottom;
    DigitalInput rightBottom;
    final String defaultAuto = "Default";
    final String customAuto = "My Auto";
    String autoSelected;
    String gripPOS = "OUT";
    String guidePOS = "OUT";
    SendableChooser chooser;
    Joystick leftStick;
    Joystick rightStick;

    public void robotInit() {
    	RoboStart();
    	comp.start();
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", defaultAuto);
        chooser.addObject("My Auto", customAuto);
        SmartDashboard.putData("Auto choices", chooser);
    }

    public void autonomousInit() {
    	
    	autoSelected = (String) chooser.getSelected();
//		autoSelected = SmartDashboard.getString("Auto Selector", defaultAuto);
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
    	gripPiston.set(DoubleSolenoid.Value.kReverse);
    	guidePiston.set(DoubleSolenoid.Value.kReverse);
    	armPiston.set(DoubleSolenoid.Value.kForward);
        while(isEnabled()&&isOperatorControl()){
        	robotDrive.tankDrive(leftStick.getRawAxis(1), rightStick.getRawAxis(1));
        	OpControl();
        }
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    public void RoboStart() {
        robotDrivelMotor = new Talon(0);
        LiveWindow.addActuator("RobotDrive", "lMotor", (Talon) robotDrivelMotor);
        
        robotDriverMotor = new Talon(1);
        LiveWindow.addActuator("RobotDrive", "rMotor", (Talon) robotDriverMotor);
        
        robotDrive = new RobotDrive(robotDrivelMotor, robotDriverMotor);
        
        robotDrive.setSafetyEnabled(true);
        robotDrive.setExpiration(0.1);
        robotDrive.setSensitivity(0.5);
        robotDrive.setMaxOutput(1.0);
        
        comp = new Compressor();
        
        gripPiston = new DoubleSolenoid(0, 0, 1);
        LiveWindow.addActuator("Grip", "Piston", gripPiston);
        
        guidePiston = new DoubleSolenoid(0, 2, 3);
        LiveWindow.addActuator("Guide", "Piston", guidePiston);
        
        liftlMotor = new Talon(2);
        LiveWindow.addActuator("Lift", "lMotor", (Talon) liftlMotor);
        
        liftrMotor = new Talon(3);
        LiveWindow.addActuator("Lift", "rMotor", (Talon) liftrMotor);
        
        armPiston = new DoubleSolenoid(0, 4, 5);
        LiveWindow.addActuator("Arm", "Piston", armPiston);
        
        leftTop = new DigitalInput(2);
        rightTop = new DigitalInput(1);
        leftBottom  = new DigitalInput(3);
        rightBottom = new DigitalInput(1);
    }
    public void OpControl(){
    	while(isEnabled()&&isOperatorControl()){
    		while(leftStick.getRawButton(2)){
        		if(leftTop.get()==false&&rightTop.get()==false){
        			liftlMotor.set(-0.5);
        			liftrMotor.set(-0.5);
        		}else{
        			liftlMotor.set(0);
        			liftrMotor.set(0);
        		}
        	}
        	while(leftStick.getRawButton(3)){
        		if(leftBottom.get()==false&&rightBottom.get()==false){
        			liftlMotor.set(-0.5);
        			liftrMotor.set(-0.5);
        		}else{
        			liftlMotor.set(0);
        			liftrMotor.set(0);
        		}
        	}
        	while(leftStick.getRawButton(1)){
        		if(isEnabled()){
					armPiston.set(DoubleSolenoid.Value.kForward);
        			//Insert Motor Control Here   		
        		}else{
					armPiston.set(DoubleSolenoid.Value.kReverse);
        		}
        	}
        	if(rightStick.getRawButton(1)){
        		switch(gripPOS){
        		case "IN":
        			gripPiston.set(DoubleSolenoid.Value.kReverse);
        			gripPOS = "OUT";
        			break;
        		case "OUT":
        			gripPiston.set(DoubleSolenoid.Value.kForward);
        			gripPOS = "IN";
        			break;
        		}
        	}
        	if(rightStick.getRawButton(2)){
        		switch(guidePOS){
        		case "IN":
        			gripPiston.set(DoubleSolenoid.Value.kReverse);
        			gripPOS = "OUT";
        			break;
        		case "OUT":
        			gripPiston.set(DoubleSolenoid.Value.kForward);
        			gripPOS = "IN";
        			break;
        		}
        	}
    	}
    }
}
