package org.usfirst.frc.team2509.robot;

import edu.wpi.first.wpilibj.*;

public class RobotMap {
	
	//Drive Train
    public static SpeedController driveTrainMotorR;
    public static SpeedController driveTrainMotorL;
    public static RobotDrive RobotDrive;
    //Guides
    public static DoubleSolenoid GuidePiston;
    //Grips
    public static DoubleSolenoid GripPiston;

    public static void init() {
    	//Define the DriveTrain Motors PWM port
    	driveTrainMotorL = new Talon(2);
    	driveTrainMotorR = new Talon(1);
    	//Define the DriveTrain and Safety
    	RobotDrive = new RobotDrive(driveTrainMotorL, driveTrainMotorR);
    	RobotDrive.setExpiration(0.1);
    	RobotDrive.setMaxOutput(1.0);
    	RobotDrive.setSafetyEnabled(true);
    	RobotDrive.setSensitivity(0.25);
    	//Define the Grips
    	GripPiston = new DoubleSolenoid(0,0,1);
    	//Define the Guides
    	GuidePiston = new DoubleSolenoid(0,2,3);
    }
}
