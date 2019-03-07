/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

// import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.elevator.Init;
import frc.robot.commands.elevator.RunManual;
import frc.robot.commands.elevator.RunRelative;
import frc.robot.commands.elevator.RunWinch;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Counter;

public class Elevator extends PIDSubsystem {
  // Circumerence times 2 (2 stage elevator)
  private final double HEIGHT_PER_ROTATION = (1.25 * Math.PI) * 2;

  private Encoder encoder;
  private DoubleSolenoid tiltenoid, grabenoid;
  private VictorSP winchMotorLeft, winchMotorRight, manipulator;
  private DifferentialDrive winch;
  //private Compressor compressor;

  private boolean autoOverride = false;

  public Elevator() {
    super(.05, .1, .1);   
    setAbsoluteTolerance(100);

    winchMotorLeft = new VictorSP(RobotMap.WINCH_MOTOR_1);
    winchMotorRight = new VictorSP(RobotMap.WINCH_MOTOR_2);
    winch = new DifferentialDrive(winchMotorLeft, winchMotorRight);

    encoder = new Encoder(0, 1);
    encoder.reset();

    tiltenoid = new DoubleSolenoid(RobotMap.ELEVATOR_TILT_SOLENOID_1, RobotMap.ELEVATOR_TILT_SOLENOID_2);
    grabenoid = new DoubleSolenoid(RobotMap.MANIPULATOR_SOLENOID_1, RobotMap.MANIPULATOR_SOLENOID_2);

    manipulator = new VictorSP(RobotMap.MANIPULATOR);

    //encoder.setDistancePerPulse(HEIGHT_PER_ROTATION);

    //this.getPIDController().setOutputRange(-1, 1);
    //init.close();
  }

  @Override
  public void initDefaultCommand() {
    // setDefaultCommand(new RunWinch());
    setDefaultCommand(new RunManual());
  }

  // runs the winch motor until motor speed set to something different
  public void run(double spd) {
    winch.tankDrive(spd, spd);
    return;
  }

  public void tilt() {
    tiltenoid.set(Value.kForward);
    return;
  }

  public void unTilt() {
    tiltenoid.set(Value.kReverse);
    return;
  }

  public void manipulatorSet(double speed) {
    manipulator.set(speed);
    return;
  }

  public void grip() {
    //System.out.println("Grip");
    grabenoid.set(Value.kForward);
    return;
  }

  public void letGo() {
    //System.out.println("Let Go");
    grabenoid.set(Value.kReverse);
    return;
  }

  // public boolean getFullDown() {
  //   return limitSwitch.get();
  // }

  public void calibrate() {
    System.out.println("CALIBRATE");
    encoder.reset();
    return;
  }

  public boolean isOverriden() {
    return autoOverride;
  }

  public void setAutoOverride(boolean value) {
    autoOverride = value;
    return;
  }

  protected double returnPIDInput() {
    return encoder.getDistance();
  }

  protected void usePIDOutput(double output) {
    //System.out.println("Distance: " + encoder.getDistance() + "\tOutput: " + (output * 0.6));
    winch.tankDrive(output * 0.6, output * 0.6);
    return;
  }
}
