package org.usfirst.frc2509.Robot.commands;

import org.usfirst.frc2509.Robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GuideOff extends Command {

    public GuideOff() {
        requires(Robot.guide);
    }

    protected void initialize() {
    	Robot.guide.Out();
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
