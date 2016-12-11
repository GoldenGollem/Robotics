package org.usfirst.frc2509.Robot.commands;

import org.usfirst.frc2509.Robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MoveGrip extends Command {
    public MoveGrip() {

    }

    protected void initialize() {
    	Robot.grip.Move();
    	end();
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
