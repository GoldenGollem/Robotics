
package org.usfirst.frc.team2509.robot;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.AxisCamera;

public class Robot extends IterativeRobot {
	//This is for the autonomous chooser
    final String defaultAuto = "Default";
    final String customAuto = "My Auto";
    String autoSelected;
    SendableChooser chooser;
    //This is for the limit switches
    DigitalInput leftLimit = new DigitalInput(2);
    DigitalInput rightLimit = new DigitalInput(1);
    DigitalInput lRight= new DigitalInput(3);
    DigitalInput lLeft = new DigitalInput(2);
    //This is for the compressor
    Compressor comp = new Compressor();
    //This is the joysticks
    Joystick Stick = new Joystick(0);
    Joystick Stick2 = new Joystick(1);
    /** This is the current Joystick layout
     * Button 1 - Front Intakes Arms
     * Button 2 - Starts the Lift motors
     * Button 3 - Extends the arms
     * Button 4 - Extends the guides
     * Button 5 - Retracts the arms
     * Button 6 - Retracts the guides
     * Throttle - Sets lift motor direction
     * Combo 2&7 - Starts the left Lift Motor 
     * Combo 2&8 - Starts the right Lift Motor
     */
    //This is for the robot drive and the motor controllers
    Talon lDrive = new Talon(0);
    Talon rDrive = new Talon(1);
    Talon lLift = new Talon(2);
    Talon rLift = new Talon(3);
  //Jaguar larm = new Jaguar(4);
  //Jaguar rarm = new Jaguar(5);
    RobotDrive chassis = new RobotDrive(lDrive,rDrive);
    //This is for the axis camera
    int session;
    Image frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
    AxisCamera camera = new AxisCamera("10.25.9.11");
	//This is for the pnuematics system
	DoubleSolenoid arms = new DoubleSolenoid(0,1);
	DoubleSolenoid guider = new DoubleSolenoid(2,3);
	DoubleSolenoid liftarm = new DoubleSolenoid(4,5);
	
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	//This is for the autonomous chooser
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", defaultAuto);
        chooser.addObject("My Auto", customAuto);
        SmartDashboard.putData("Auto choices", chooser);
        //This starts the compressor as the robot starts up
        comp.start();
        
		
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
        guider.set(DoubleSolenoid.Value.kForward);  
        Timer.delay(2.0);
        guider.set(DoubleSolenoid.Value.kReverse);
        Timer.delay(2.0);
        guider.set(DoubleSolenoid.Value.kOff);
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
    	
    	//This is for the camera
    	NIVision.Rect rect = new NIVision.Rect(10, 10, 100, 100);
    	while (isOperatorControl() && isEnabled()) {
    		chassis.tankDrive(Stick.getY(), Stick2.getY());
            camera.getImage(frame);
            NIVision.imaqDrawShapeOnImage(frame, frame, rect, DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);
            CameraServer.getInstance().setImage(frame);
        }
        //This is to activate the front arms
      /*  if(Stick.getRawButton(1)){
        	arms.set(DoubleSolenoid.Value.kForward);
        	larm.set(0.6);
        	rarm.set(-0.6);
        }else{
        	larm.set(0.0);
        	rarm.set(0.0);
        	arms.set(DoubleSolenoid.Value.kReverse);
        }*/
        //This is to extend and retract the box grabbers
        if(Stick.getRawButton(4)){
        	liftarm.set(DoubleSolenoid.Value.kForward);
        }else if(Stick.getRawButton(5)){
        	liftarm.set(DoubleSolenoid.Value.kReverse);
        }
        //This is to extend and retract the back guides
        if(Stick.getRawButton(2)){
        	guider.set(DoubleSolenoid.Value.kForward);
        }else if(Stick.getRawButton(3)){
        	guider.set(DoubleSolenoid.Value.kReverse);
        }
        //This is to raise and lower the lift
        if(Stick2.getRawButton(3)){
        	if(rightLimit.get()==false&&leftLimit.get()==false){
        	rLift.set(0.75);
        	lLift.set(0.75);
        	}
        }else if(Stick2.getRawButton(2)){
        	if(lLeft.get()==false&&lRight.get()==false){
        		rLift.set(-0.75);
        		lLift.set(-0.75);
        	}        	
        }else{
        	rLift.set(0.0);
        	lLift.set(0.0);
        }
        //This is to recalibrate the lift locations
        if((Stick2.getRawButton(2)&&Stick2.getRawButton(7))&&leftLimit.get()){
        	lLift.set(0.5);
        }else if((Stick2.getRawButton(2)&&Stick2.getRawButton(8))&&rightLimit.get()){
        	rLift.set(0.5);
        }else{
        	lLift.set(0.0);
        	rLift.set(0.0);
        }
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
}