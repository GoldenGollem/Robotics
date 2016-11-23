package org.usfirst.frc.team2509.robot;

import edu.wpi.first.wpilibj.*;

public class RobotMap {
	
	//Drive Train
    public static SpeedController driveTrainMotorR;
    public static SpeedController driveTrainMotorL;
    public static RobotDrive RobotDrive;
    //Compressor
    public static Compressor comp;
    //Guides
    public static DoubleSolenoid GuidePiston;
    //Grips
    public static DoubleSolenoid GripPiston;
    //Lift
    public static SpeedController liftMotorL;
    public static SpeedController liftMotorR;
    public static DigitalInput LimitLT;
    public static DigitalInput LimitRT;
    public static DigitalInput LimitLB;
    public static DigitalInput LimitRB;

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
    	//Define the Compressor
    	comp = new Compressor();
    	//Define the Grips
    	GripPiston = new DoubleSolenoid(0,0,1);
    	//Define the Guides
    	GuidePiston = new DoubleSolenoid(0,2,3);
    	//Define the Lift
    	liftMotorL = new Talon(2);
    	liftMotorR = new Talon(3);
    	LimitLT = new DigitalInput(2);
    	LimitLB = new DigitalInput(3);
    	LimitRT = new DigitalInput(1);
    	LimitRB = new DigitalInput(0);
    }
}
