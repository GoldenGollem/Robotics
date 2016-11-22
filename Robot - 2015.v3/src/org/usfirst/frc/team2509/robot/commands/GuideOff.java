package org.usfirst.frc.team2509.robot.commands;

import org.usfirst.frc.team2509.robot.Robot;
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
    	Robot.guide.Standbye();
    }

    protected void interrupted() {
    	end();
    }
}
