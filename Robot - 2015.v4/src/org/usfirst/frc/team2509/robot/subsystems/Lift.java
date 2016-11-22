package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.*;

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
    	if(BotLeft.get() == false){
    		
    	}
    }
    public void CalibrateRight(){
    	
    }
    
}

