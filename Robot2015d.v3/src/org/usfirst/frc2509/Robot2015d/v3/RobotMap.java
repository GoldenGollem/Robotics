package org.usfirst.frc2509.Robot2015d.v3;

import edu.wpi.first.wpilibj.*;

import edu.wpi.first.wpilibj.livewindow.*;

public class RobotMap {
    public static SpeedController robotDrivelMotor;
    public static SpeedController robotDriverMotor;
    public static RobotDrive robotDrive;
    public static DoubleSolenoid gripPiston;
    public static DoubleSolenoid guidePiston;
    public static SpeedController liftlMotor;
    public static SpeedController liftrMotor;
    public static DoubleSolenoid armPiston;
    public static DigitalInput leftTop;
    public static DigitalInput rightTop;
    public static DigitalInput leftBottom;
    public static DigitalInput rightBottom;

    public static void init() {
        robotDrivelMotor = new Talon(0);
        LiveWindow.addActuator("RobotDrive", "lMotor", (Talon) robotDrivelMotor);
        robotDrivelMotor.setInverted(true);
        
        robotDriverMotor = new Talon(1);
        LiveWindow.addActuator("RobotDrive", "rMotor", (Talon) robotDriverMotor);
        robotDriverMotor.setInverted(true);
        
        robotDrive = new RobotDrive(robotDrivelMotor, robotDriverMotor);
        
        robotDrive.setSafetyEnabled(true);
        robotDrive.setExpiration(0.1);
        robotDrive.setSensitivity(0.5);
        robotDrive.setMaxOutput(1.0);
        
        gripPiston = new DoubleSolenoid(0, 0, 1);
        LiveWindow.addActuator("Grip", "Piston", gripPiston);
        
        guidePiston = new DoubleSolenoid(0, 2, 3);
        LiveWindow.addActuator("Guide", "Piston", guidePiston);
        
        liftlMotor = new Talon(2);
        LiveWindow.addActuator("Lift", "lMotor", (Talon) liftlMotor);
        
        liftrMotor = new Talon(3);
        LiveWindow.addActuator("Lift", "rMotor", (Talon) liftrMotor);
        
        armPiston = new DoubleSolenoid(0, 4, 5);
        LiveWindow.addActuator("Arm", "Piston", armPiston);
        
        leftTop = new DigitalInput(2);
        rightTop = new DigitalInput(1);
        leftBottom  = new DigitalInput(3);
        rightBottom = new DigitalInput(0);
    }
}
