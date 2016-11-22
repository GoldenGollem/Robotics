package org.usfirst.frc.team2509.robot.commands;

import org.usfirst.frc.team2509.robot.Robot;
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
    	Robot.grip.Standbye();
    }

    protected void interrupted() {
    	end();
    }
}
