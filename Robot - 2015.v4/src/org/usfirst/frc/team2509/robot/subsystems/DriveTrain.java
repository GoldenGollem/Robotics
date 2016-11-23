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
    public void Forward(){
    	lMotor.set(0.5);
    	rMotor.set(0.5);
    }
    public void Backward(){
    	lMotor.set(-0.5);
    	rMotor.set(-0.5);
    }
    public void Stop(){
    	lMotor.set(0);
    	rMotor.set(0);
    }
}

