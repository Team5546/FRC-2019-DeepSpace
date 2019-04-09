/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;
import frc.robot.commands.elevator.Init;
import frc.robot.commands.elevator.Tilt;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.ClimbTrain;
import frc.robot.commands.elevator.Grab;
import frc.robot.commands.elevator.LetGo;

public class Robot extends TimedRobot {
  // public static ExampleSubsystem m_subsystem = new ExampleSubsystem();
  public static OI oi;
  public static DriveTrain driveTrain;
  public static Elevator elevator;
  public static Climb climb;
  public static UsbCamera floorCam, climbCam;
  public static Gyro gyro;
  public static ClimbTrain climbTrain;

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    driveTrain = new DriveTrain();
    elevator = new Elevator();
    climb = new Climb();
    climbTrain = new ClimbTrain();
    gyro = new Gyro();

    oi = new OI();
    
    climb.stop();
    elevator.calibrate();
    //SmartDashboard.putData("PID", elevator.getPIDController());
    //SmartDashboard.putData(new Grab());
    //SmartDashboard.putData(new LetGo());

    //floorCam = CameraServer.getInstance().startAutomaticCapture(0);
    //climbCam = CameraServer.getInstance().startAutomaticCapture(1);
    //CameraServer.getInstance().addAxisCamera("10.55.46.15");
    //CameraServer.getInstance().addCamera(floorCam);
    //CameraServer.getInstance().addCamera(climbCam);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    //System.out.println("Pitch: " + (int) ahrs.getPitch() + " | Roll: " + (int) ahrs.getRoll() + " | Yaw: " + (int) ahrs.getYaw());
  }

  /**
   * This function is called once each time the robot enters Disabled mode. You
   * can use it to reset any subsystem information you want to clear when the
   * robot is disabled.
   */
  @Override
  public void disabledInit() {
    elevator.unTilt();
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable chooser
   * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
   * remove all of the chooser code and uncomment the getString code to get the
   * auto name from the text box below the Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons to
   * the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    Init init = new Init();
    init.start();
    //init.close();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
    if (oi.rightStick.getTwist() > 0.9 || oi.rightStick.getTwist() < -0.9)
      elevator.manipulatorSet(-oi.rightStick.getTwist() + .15);
    else
      elevator.manipulatorSet(0);

    double twist = Robot.oi.leftStick.getTwist();
    if (twist > 0.5 || twist < -0.5)
      Robot.elevator.run(-twist);
    else
      Robot.elevator.run(0);
  }

  @Override
  public void teleopInit() {
    //elevator.calibrate();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    // if (oi.rightStick.getX() > 0.5 || oi.rightStick.getX() < -0.5) climb.runForce(oi.rightStick.getX());
    // else climb.runForce(0);

    // if (oi.driveClimb.get()) climb.driveForward();
    // else climb.driveStop();
    
    // System.out.println("Left X: " + oi.rightStick.getX());
    // elevator.run(oi.leftStick.getX() * 0.8);
    if (oi.rightStick.getTwist() > 0.9 || oi.rightStick.getTwist() < -0.9) elevator.manipulatorSet(-oi.rightStick.getTwist() + .15);
    else elevator.manipulatorSet(0);

    if (!climb.override) {
      if (oi.rightStick.getX() > 0.5 || oi.rightStick.getX() < -0.5)
        climb.runForce(oi.rightStick.getX());
      else
        climb.runForce(0);
    }
    if (!climbTrain.override) {
      if (oi.rightStick.getTrigger())
        climbTrain.driveForward();
      else
        climbTrain.driveStop();
    }
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
