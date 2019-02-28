/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;
import frc.robot.commands.elevator.Init;
import frc.robot.commands.elevator.Tilt;
import frc.robot.subsystems.Climb;

public class Robot extends TimedRobot {
  // public static ExampleSubsystem m_subsystem = new ExampleSubsystem();
  public static OI oi;
  public static DriveTrain driveTrain;
  public static Elevator elevator;
  public static Climb climb;

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    driveTrain = new DriveTrain();
    elevator = new Elevator();
    climb = new Climb();
    oi = new OI();
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
  }

  @Override
  public void teleopInit() {
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
    if (oi.rightStick.getTwist() > 0.75 || oi.rightStick.getTwist() < -0.75) elevator.manipulatorSet(oi.rightStick.getTwist());
    else elevator.manipulatorSet(0);
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
