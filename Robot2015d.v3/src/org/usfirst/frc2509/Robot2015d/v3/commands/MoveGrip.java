package org.usfirst.frc2509.Robot2015d.v3.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2509.Robot2015d.v3.Robot;

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
