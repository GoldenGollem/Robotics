package org.usfirst.frc2509.Robot.subsystems;

import org.usfirst.frc2509.Robot.RobotMap;
import org.usfirst.frc2509.Robot.commands.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class RobotDrive extends Subsystem {
    private final SpeedController lMotor = RobotMap.robotDrivelMotor;
    private final SpeedController rMotor = RobotMap.robotDriverMotor;
    private final edu.wpi.first.wpilibj.RobotDrive robotDrive = RobotMap.robotDrive;

    public void initDefaultCommand() {

    }
    public void OpControl(Joystick stick1, Joystick stick2){
    	robotDrive.tankDrive(stick1.getY(), stick2.getY());
    }
    
}

