package org.usfirst.frc.team2509.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class RobotMap {
    public static Compressor Comp;
    public static SpeedController driveTrainMotorR;
    public static SpeedController driveTrainMotorL;
    public static RobotDrive driveTrainRobotDrive;
    public static DoubleSolenoid gripDoubleSolenoid;
    public static DoubleSolenoid guideDoubleSolenoid;
    public static SpeedController intakeRightMotor;
    public static SpeedController intakeLeftMotor;
    public static DoubleSolenoid intakeDoubleSolenoid;
    public static SpeedController leftLiftMotorL;
    public static DigitalInput leftLiftLimitSwitchLT;
    public static DigitalInput leftLiftLimitSwitchLB;
    public static DigitalInput rightLiftLimitSwitchRT;
    public static DigitalInput rightLiftLimitSwitchRB;
    public static SpeedController rightLiftMotorR;


    public static void init() {
        Comp = new Compressor(0);
        
        
        driveTrainMotorR = new Talon(0);
        LiveWindow.addActuator("Drive Train", "Motor R", (Talon) driveTrainMotorR);
        
        driveTrainMotorL = new Talon(1);
        LiveWindow.addActuator("Drive Train", "Motor L", (Talon) driveTrainMotorL);
        
        driveTrainRobotDrive = new RobotDrive(driveTrainMotorL, driveTrainMotorR);
        
        driveTrainRobotDrive.setSafetyEnabled(true);
        driveTrainRobotDrive.setExpiration(0.1);
        driveTrainRobotDrive.setSensitivity(0.5);
        driveTrainRobotDrive.setMaxOutput(1.0);

        gripDoubleSolenoid = new DoubleSolenoid(0, 2, 3);
        LiveWindow.addActuator("Grip", "Double Solenoid", gripDoubleSolenoid);

        gripDoubleSolenoid = new DoubleSolenoid(0, 4, 5);
        LiveWindow.addActuator("Guide", "Double Solenoid", guideDoubleSolenoid);
        
        intakeRightMotor = new Talon(4);
        LiveWindow.addActuator("Intake", "Right Motor", (Talon) intakeRightMotor);
        
        intakeLeftMotor = new Talon(5);
        LiveWindow.addActuator("Intake", "Left Motor", (Talon) intakeLeftMotor);

        intakeDoubleSolenoid = new DoubleSolenoid(0, 0, 1);
        LiveWindow.addActuator("Intake", "Double Solenoid", intakeDoubleSolenoid);
        
        leftLiftMotorL = new Talon(2);
        LiveWindow.addActuator("Left Lift", "Motor L", (Talon) leftLiftMotorL);
        
        leftLiftLimitSwitchLT = new DigitalInput(0);
        LiveWindow.addSensor("Left Lift", "Limit Switch 1", leftLiftLimitSwitchLT);
        
        leftLiftLimitSwitchLB = new DigitalInput(1);
        LiveWindow.addSensor("Left Lift", "Limit Switch 2", leftLiftLimitSwitchLB);
        
        rightLiftLimitSwitchRT = new DigitalInput(2);
        LiveWindow.addSensor("Right Lift", "Limit Switch 3", rightLiftLimitSwitchRT);
        
        rightLiftLimitSwitchRB = new DigitalInput(3);
        LiveWindow.addSensor("Right Lift", "Limit Switch 4", rightLiftLimitSwitchRB);
        
        rightLiftMotorR = new Talon(3);
        LiveWindow.addActuator("Right Lift", "Motor R", (Talon) rightLiftMotorR);
        
    }
}
