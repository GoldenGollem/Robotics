package org.usfirst.frc.team2509.robot;

import edu.wpi.first.wpilibj.*;

public class RobotMap {
    public static SpeedController driveTrainMotorR;
    public static SpeedController driveTrainMotorL;
    public static RobotDrive RobotDrive;
    
    public static void init() {
    	//Define the DriveTrain Motors PWM port
    	driveTrainMotorL = new Talon(0);
    	driveTrainMotorR = new Talon(1);
    	//Define the DriveTrain and Safety
    	RobotDrive = new RobotDrive(driveTrainMotorL, driveTrainMotorR);
    	RobotDrive.setExpiration(0.1);
    	RobotDrive.setMaxOutput(1.0);
    	RobotDrive.setSafetyEnabled(true);
    	RobotDrive.setSensitivity(0.25);
    }
}
