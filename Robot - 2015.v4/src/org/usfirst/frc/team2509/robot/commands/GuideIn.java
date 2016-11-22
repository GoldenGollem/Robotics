package org.usfirst.frc.team2509.robot.commands;

import org.usfirst.frc.team2509.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class GuideIn extends Command {

    public GuideIn() {
    	requires(Robot.guide);
    }

    protected void initialize() {
    	Robot.guide.In();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.guide.Standbye();
    }

    protected void interrupted() {
    	end();
    }
}
