
package org.usfirst.frc2509.Robot2015d.v3.subsystems;

import org.usfirst.frc2509.Robot2015d.v3.Robot;
import org.usfirst.frc2509.Robot2015d.v3.RobotMap;
import org.usfirst.frc2509.Robot2015d.v3.commands.*;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Lift extends Subsystem {
    private final SpeedController lMotor = RobotMap.liftlMotor;
    private final SpeedController rMotor = RobotMap.liftrMotor;
    private final DigitalInput leftTop = RobotMap.leftTop;
    private final DigitalInput rightTop = RobotMap.rightTop;
    private final DigitalInput leftBottom = RobotMap.leftBottom;
    private final DigitalInput rightBottom = RobotMap.rightBottom;

    public void initDefaultCommand() {
    }
    public void Up(){
    	while(leftTop.get()==false&&rightTop.get()==false){
    		lMotor.set(0.5);
    		rMotor.set(0.5);
    	}
    }
    public void Down(){
    	while(leftBottom.get()==false&&rightBottom.get()==false){
    		lMotor.set(-0.5);
    		rMotor.set(-0.5);
    	}
    }
    public void Stop(){
    	lMotor.set(0);
    	rMotor.set(0);
    }
    public void CalibpateLeftUp(){
    	lMotor.set(0.5);
    }
    public void CalibrateRightUp(){
    	rMotor.set(0.5);
    }
    public void CalibrateLeftDown(){
    	lMotor.set(-0.5);
    }
    public void CalibrateRightDown(){
    	rMotor.set(-0.5);
    }
}

