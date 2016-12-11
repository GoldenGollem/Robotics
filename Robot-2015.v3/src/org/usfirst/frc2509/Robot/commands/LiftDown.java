package org.usfirst.frc2509.Robot.commands;

import org.usfirst.frc2509.Robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LiftDown extends Command {

    public LiftDown() {

    }

    protected void initialize() {
    	Robot.lift.Down();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.lift.Stop();
    }

    protected void interrupted() {
    	end();
    }
}
