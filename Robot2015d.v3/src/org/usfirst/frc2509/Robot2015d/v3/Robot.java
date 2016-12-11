package org.usfirst.frc2509.Robot2015d.v3;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.livewindow.*;
import org.usfirst.frc2509.Robot2015d.v3.commands.*;
import org.usfirst.frc2509.Robot2015d.v3.subsystems.*;
import org.usfirst.frc2509.Robot2015d.v3.subsystems.RobotDrive;

public class Robot extends IterativeRobot {

    Command autonomousCommand;

    public static OI oi;
    public static Compressor comp;
    public static RobotDrive robotDrive;
    public static Grip grip;
    public static Guide guide;
    public static Lift lift;
    public static ArmPiston armPiston;
    public static ArmMotors armMotor;
    public Joystick leftStick;
    public Joystick rightStick;


    public void robotInit() {
    	RobotMap.init();
        robotDrive = new RobotDrive();
        grip = new Grip();
        guide = new Guide();
        lift = new Lift();
        armPiston = new ArmPiston();
        armMotor = new ArmMotors();

        /**
         * OI must be constructed after subsystems. If the OI creates Commands
         * (which it very likely will), subsystems are not guaranteed to be
         * constructed yet. Thus, their requires() statements may grab null
         * pointers. Bad news. Don't move it.
         */
        
        oi = new OI();
        
        leftStick = Robot.oi.lStick;
        rightStick = Robot.oi.rStick;
        autonomousCommand = new AutonomousCommand();
    }

    public void disabledInit(){

    }

    //public void disabledPeriodic() {
    //    Scheduler.getInstance().run();
    //}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    public void teleopPeriodic() {
        
        while(isEnabled()&&isOperatorControl()){
        	Scheduler.getInstance().run();
        	Robot.robotDrive.OpControl(leftStick, rightStick);
        	Robot.oi.CheckDigital();
        }
    }

    public void testPeriodic() {
        LiveWindow.run();
    }
}
