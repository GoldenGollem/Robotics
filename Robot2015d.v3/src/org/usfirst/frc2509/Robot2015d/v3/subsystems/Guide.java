package org.usfirst.frc2509.Robot2015d.v3.subsystems;

import org.usfirst.frc2509.Robot2015d.v3.RobotMap;
import org.usfirst.frc2509.Robot2015d.v3.commands.*;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Guide extends Subsystem {
    private final DoubleSolenoid piston = RobotMap.guidePiston;
    private boolean Position = false;

    public void initDefaultCommand() {
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
