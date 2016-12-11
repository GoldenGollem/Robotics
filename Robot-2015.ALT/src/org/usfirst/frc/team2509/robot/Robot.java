
package org.usfirst.frc.team2509.robot;


import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.livewindow.*;
import edu.wpi.first.wpilibj.smartdashboard.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	SpeedController robotDrivelMotor;
    SpeedController robotDriverMotor;
    RobotDrive robotDrive;
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
    SendableChooser chooser;
    Joystick leftStick;
    Joystick rightStick;
    
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	RoboStart();
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", defaultAuto);
        chooser.addObject("My Auto", customAuto);
        SmartDashboard.putData("Auto choices", chooser);
    }
    
	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString line to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the switch structure below with additional strings.
	 * If using the SendableChooser make sure to add them to the chooser code above as well.
	 */
    public void autonomousInit() {
    	autoSelected = (String) chooser.getSelected();
//		autoSelected = SmartDashboard.getString("Auto Selector", defaultAuto);
		System.out.println("Auto selected: " + autoSelected);
    }

    /**
     * This function is called periodically during autonomous
     */
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

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        while(isEnabled()&&isOperatorControl()){
        	robotDrive.tankDrive(leftStick.getRawAxis(1), rightStick.getRawAxis(1));
        	while(leftStick.getRawButton(2)){
        		if(leftTop.get()==false&&rightTop.get()==false){
        			liftlMotor.set(0.5);
        			liftrMotor.set(0.5);
        		}else{
        			liftlMotor.set(0);
        			liftrMotor.set(0);
        		}
        	}
        	while(leftStick.getRawButton(3)){
        		if(leftBottom.get()==false&&rightBottom.get()==false){
        			liftlMotor.set(0.5);
        			liftrMotor.set(0.5);
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
}
