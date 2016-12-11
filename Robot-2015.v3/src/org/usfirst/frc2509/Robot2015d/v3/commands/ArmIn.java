package org.usfirst.frc2509.Robot2015d.v3.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2509.Robot2015d.v3.Robot;

public class ArmIn extends Command {

    public ArmIn() {
    	requires(Robot.armPiston);
    }

    protected void initialize() {
    	Robot.armPiston.In();
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
