package org.usfirst.frc2509.Robot2015d.v3.subsystems;

import org.usfirst.frc2509.Robot2015d.v3.RobotMap;
import org.usfirst.frc2509.Robot2015d.v3.commands.*;
import edu.wpi.first.wpilibj.*;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ArmPiston extends Subsystem {
    private final DoubleSolenoid piston = RobotMap.armPiston;
    public void initDefaultCommand() {
        setDefaultCommand(new ArmOut());
    }
    public void In(){
    	piston.set(DoubleSolenoid.Value.kForward);
    }
    public void Out(){
    	piston.set(DoubleSolenoid.Value.kReverse);
    }
}

