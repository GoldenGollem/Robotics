package org.usfirst.frc2509.Robot.commands;

import org.usfirst.frc2509.Robot.subsystems.ArmPiston;

import edu.wpi.first.wpilibj.command.Command;

public class ArmMove extends Command {
	public static ArmPiston piston;
    public ArmMove() {
    	
    }

    protected void initialize() {
    	piston.Out();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	piston.In();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
