package org.usfirst.frc2509.Robot.commands;

import org.usfirst.frc2509.Robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LiftUp extends Command {

    public LiftUp() {
    }

    protected void initialize() {
    	if(Robot.lift.getTopLimit()==false){
    		Robot.lift.Up();
    	}
    }
    
    protected void execute() {
    	if(Robot.lift.getTopLimit()==true){
    		end();
    	}
    }

    protected boolean isFinished() {
    	return Robot.lift.getTopLimit();
    }

    protected void end() {
    	Robot.lift.Stop();
    }

    protected void interrupted() {
    	end();
    }
}
