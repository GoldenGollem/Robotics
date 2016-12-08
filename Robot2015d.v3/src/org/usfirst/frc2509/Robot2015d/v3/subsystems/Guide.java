// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2509.Robot2015d.v3.subsystems;

import org.usfirst.frc2509.Robot2015d.v3.RobotMap;
import org.usfirst.frc2509.Robot2015d.v3.commands.*;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Guide extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final DoubleSolenoid piston = RobotMap.guidePiston;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private boolean Position = false;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

     //   setDefaultCommand(new GripOut());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
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
