
package org.usfirst.frc.team2509.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team2509.robot.commands.*;
import org.usfirst.frc.team2509.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.*;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static DriveTrain RobotDrive;
	public static Guide guide;
	public static Grips grip;
	public static OI oi;
	Joystick lStick = Robot.oi.leftStick;
	Joystick rStick = Robot.oi.rightStick;
    Command autonomousCommand;
    SendableChooser chooser;

    public void robotInit() {
    	RobotMap.init();
		oi = new OI();
		RobotDrive = new DriveTrain();
		guide = new Guide();
		grip = new Grips();
        /*
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", new ExampleCommand());
        chooser.addObject("My Auto", new MyAutoCommand());
        SmartDashboard.putData("Auto mode", chooser);
         */
    }
    
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();
        if (autonomousCommand != null) autonomousCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
        while(isEnabled() && isOperatorControl()){
        	RobotDrive.OpDrive(lStick, rStick);
        }
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}
