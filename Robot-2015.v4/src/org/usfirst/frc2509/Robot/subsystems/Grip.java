package org.usfirst.frc2509.Robot.subsystems;

import org.usfirst.frc2509.Robot.RobotMap;
import org.usfirst.frc2509.Robot.commands.*;

import edu.wpi.first.wpilibj.DoubleSolenoid;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Grip extends Subsystem {
    private final DoubleSolenoid piston = RobotMap.gripPiston;
    private boolean Position = false;
    public void initDefaultCommand() {
        setDefaultCommand(new GripOut());
    }
    public void In(){
    	piston.set(DoubleSolenoid.Value.kForward);
    	Position = true;
    }
    public void Out(){
    	piston.set(DoubleSolenoid.Value.kReverse);
    	Position = false;
    }
    public void Move(){
    	if(Position == false){
    		In();
    	}else if(Position==true){
    		Out();
    	}else{
    		piston.set(DoubleSolenoid.Value.kOff);
    	}
    }
}

