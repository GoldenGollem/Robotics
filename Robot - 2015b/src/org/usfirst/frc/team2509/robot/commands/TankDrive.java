package org.usfirst.frc.team2509.robot.commands;

import org.usfirst.frc.team2509.robot.*;
import org.usfirst.frc.team2509.robot.subsystems.*;
import org.usfirst.frc.team2509.robot.commands.*;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TankDrive extends Command {

    public TankDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.driveTrainRobotDrive.tankDrive(Robot.oi.gamepad.getRawAxis(1), 
    			Robot.oi.gamepad.getRawAxis(3));
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.tankDrive(Robot.oi.gamepad);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

//public void DriveControl(){
//	robotDrive.tankDrive(Robot.oi.gamepad.getRawAxis(1), 
//			Robot.oi.gamepad.getRawAxis(3));