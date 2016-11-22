package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;

public class DriveTrain extends Subsystem {
	private final SpeedController rMotor = RobotMap.driveTrainMotorR;
	private final SpeedController lMotor = RobotMap.driveTrainMotorL;
	private final RobotDrive RobotDrive = RobotMap.RobotDrive;

    public void initDefaultCommand() {
    
    }
    public void OpDrive(Joystick leftstick, Joystick rightstick){
    	RobotDrive.tankDrive(leftstick.getX(), rightstick.getX());
    }
}

