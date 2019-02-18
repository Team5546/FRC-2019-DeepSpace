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
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.elevator.ElevatorInit;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Counter;

public class Elevator extends PIDSubsystem {
  // Circumerence times 2 (2 stage elevator)
  private final double HEIGHT_PER_ROTATION = (1.25 * Math.PI) * 2;

  private DigitalInput limitSwitch;
  private Counter encoder;
  private Solenoid tiltenoid, lockenoid;
  private VictorSP winchMotorLeft, winchMotorRight;
  private DifferentialDrive winch;

  public Elevator() {
    // currently copied values from last year for Super
    super(4.0, 0.1, 0.0);

    winchMotorLeft = new VictorSP(RobotMap.WINCH_MOTOR_1);
    winchMotorRight = new VictorSP(RobotMap.WINCH_MOTOR_2);
    winch = new DifferentialDrive(winchMotorLeft, winchMotorRight);
    limitSwitch = new DigitalInput(RobotMap.ELEVATOR_LIMIT);
    encoder = new Counter(RobotMap.ELEVATOR_ENCODER);
    tiltenoid = new Solenoid(RobotMap.ELEVATOR_TILT_SOLENOID);
    lockenoid = new Solenoid(RobotMap.ELEVATOR_LOCK_SOLENOID);

    encoder.setDistancePerPulse(HEIGHT_PER_ROTATION);

    this.getPIDController().setOutputRange(-1, 1);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ElevatorInit());
  }

  // runs the winch motor until motor speed set to something different
  public void run(double spd) {
    winch.tankDrive(spd, spd);
    return;
  }

  public void unlock() {
    lockenoid.set(true);
    return;
  }

  public void tilt() {
    tiltenoid.set(true);
    return;
  }

  public boolean getFullDown() {
    return limitSwitch.get();
  }

  public void calibrate() {
    encoder.reset();
    this.setSetpoint(0);
    this.enable();
    return;
  }

  protected double returnPIDInput() {
    return encoder.getDistance();
  }

  protected void usePIDOutput(double output) {
    run(output);
    return;
  }
}
