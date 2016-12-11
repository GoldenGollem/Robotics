package org.usfirst.frc2509.Robot.commands;

import org.usfirst.frc2509.Robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArmOut extends Command {
    public ArmOut() {
    	requires(Robot.armPiston);

    }

    protected void initialize() {
    	Robot.armPiston.Out();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    	end();
    }
}
