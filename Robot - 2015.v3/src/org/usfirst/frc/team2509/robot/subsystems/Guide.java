package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Guide extends Subsystem {
	public final DoubleSolenoid piston = RobotMap.GuidePiston;
    public void initDefaultCommand() {

    }
    public void In(){
    	piston.set(DoubleSolenoid.Value.kForward);
    }
    public void Out(){
    	piston.set(DoubleSolenoid.Value.kReverse);
    }
    public void Standbye(){
    	piston.set(DoubleSolenoid.Value.kOff);
    }
}

