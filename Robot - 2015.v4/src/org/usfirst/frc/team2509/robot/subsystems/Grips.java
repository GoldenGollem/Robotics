package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Grips extends Subsystem {
	public final DoubleSolenoid piston = RobotMap.GripPiston;
    public void initDefaultCommand() {

    }
    public void In(){
    	piston.set(DoubleSolenoid.Value.kForward);
    }
    public void Off(){
    	piston.set(DoubleSolenoid.Value.kReverse);
    }
    public void Standbye(){
    	piston.set(DoubleSolenoid.Value.kOff);
    }
}

