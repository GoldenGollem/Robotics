package org.usfirst.frc2509.Robot.commands;

import org.usfirst.frc2509.Robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GripIn extends Command {
    public GripIn() {
        requires(Robot.grip);
    }
    protected void initialize() {
    	Robot.grip.In();
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
