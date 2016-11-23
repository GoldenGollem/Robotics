package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.Robot;
import org.usfirst.frc.team2509.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.wpilibj.*;

public class Lift extends Subsystem {
	
	public final SpeedController motorL = RobotMap.liftMotorL;
	public final SpeedController motorR = RobotMap.liftMotorR;
	public final DigitalInput TopLeft = RobotMap.LimitLT;
	public final DigitalInput TopRight = RobotMap.LimitRT;
	public final DigitalInput BotLeft = RobotMap.LimitLB;
	public final DigitalInput BotRight = RobotMap.LimitRB;
	
    public void initDefaultCommand() {
    }
    public void Up(){
    	if((TopLeft.get() == false)&&(TopRight.get()==false)){
    		motorL.set(-0.5);
    		motorR.set(-0.5);
    	}else{
    		motorR.set(0);
    		SmartDashboard.putBoolean("Can Lift Go Up", (BotLeft.get()&&BotRight.get()));
    	}
    }
    public void Down(){
    	if((BotLeft.get() == false)&&(BotRight.get()==false)){
    		motorL.set(-0.5);
    		motorR.set(-0.5);
    	}else{
    		motorR.set(0);
    		SmartDashboard.putBoolean("Can Lift Go Down", (BotLeft.get()&&BotRight.get()));
    	}
    }
    public void Stop(){
    	motorL.set(0);
    	motorR.set(0);
    }
    public void CalibrateLeft(){
    	if(Robot.oi.leftStick.getRawButton(6)&&Robot.oi.leftStick.getRawButton(7)&&Robot.oi.leftStick.getRawButton(8)){
    		motorL.set(-0.25);
    	}else if(Robot.oi.leftStick.getRawButton(5)&&Robot.oi.leftStick.getRawButton(7)&&Robot.oi.leftStick.getRawButton(8)){
    		motorL.set(0.25);
    	}else{
    		motorL.set(0);
    	}
    }
    public void CalibrateRight(){
    	if(Robot.oi.rightStick.getRawButton(6)&&Robot.oi.rightStick.getRawButton(7)&&Robot.oi.rightStick.getRawButton(8)){
    		motorR.set(-0.25);
    	}else if(Robot.oi.rightStick.getRawButton(5)&&Robot.oi.rightStick.getRawButton(7)&&Robot.oi.rightStick.getRawButton(8)){
    		motorR.set(0.25);
    	}else{
    		motorR.set(0);
    	}
    }
    public void CheckDigital(){
    	SmartDashboard.putBoolean("L Limit Top", TopLeft.get());
        SmartDashboard.putBoolean("L Limit Bottom", BotLeft.get());
        SmartDashboard.putBoolean("R Limit Top", TopRight.get());
        SmartDashboard.putBoolean("R Limit Bottom", BotRight.get());

    }    
}

