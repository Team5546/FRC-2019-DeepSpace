/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.gyro;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class GyroClimb extends Command {

  private static final int MAX_ANGLE = 20;

  double leg_base_speed = 0.9;
  double elevator_base_speed = 0.95;

  public GyroClimb() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.climb);
    requires(Robot.elevator);
    requires(Robot.gyro);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //System.out.println("GryoClimb()");
    Robot.climb.setOverride(true);
    Robot.elevator.setAutoOverride(true);

    if (RobotController.getBatteryVoltage() > 12.25) {
      leg_base_speed = 0.9;
      elevator_base_speed = 0.85;
    }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    float delta_a = Robot.gyro.getClimbTilt();

    double leg_adjustment = delta_a * (1 - leg_base_speed) / MAX_ANGLE;
    double leg_speed = leg_base_speed - leg_adjustment;

    double elevator_adjustment = delta_a * (1 - elevator_base_speed) / MAX_ANGLE;
    double elevator_speed = elevator_base_speed + elevator_adjustment;

    //System.out.println("V: " + RobotController.getBatteryVoltage() + " | Gyro: " + delta_a + " | Leg: " + leg_speed + " | Elevator: " + elevator_speed);
    Robot.elevator.run(elevator_speed);
    Robot.climb.runForce(leg_speed);
    //Robot.elevator.run(0);
    //Robot.climb.runForce(0);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.elevator.run(0);
    Robot.climb.runForce(0);

    Robot.elevator.setAutoOverride(false);
    Robot.climb.setOverride(false);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.elevator.run(0);
    Robot.climb.runForce(0);

    Robot.elevator.setAutoOverride(false);
    Robot.climb.setOverride(false);
  }
}
