package org.usfirst.frc.team2509.robot.commands;

import org.usfirst.frc.team2509.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GripOff extends Command {

    public GripOff() {
    	requires(Robot.grip);
    }

    protected void initialize() {
    	Robot.grip.Off();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.grip.Standbye();
    }

    protected void interrupted() {
    	end();
    }
}