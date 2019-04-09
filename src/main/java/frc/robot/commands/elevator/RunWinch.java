/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RunWinch extends Command {
  // private static final double HEIGHT_PER_ROTATION = (1.25 * Math.PI) * 2;

  // private static final double LEVEL_1 = 12.5 * HEIGHT_PER_ROTATION;
  // private static final double LEVEL_2 = 30.5 *HEIGHT_PER_ROTATION;
  // private static final double LEVEL_3 = 58.5 * HEIGHT_PER_ROTATION;

  // private static final double BALL_LEVEL_1 = 21 * HEIGHT_PER_ROTATION;
  // private static final double BALL_LEVEL_2 = 49 * HEIGHT_PER_ROTATION;
  // private static final double BALL_LEVEL_3 = 77 * HEIGHT_PER_ROTATION;

  private double speed;

  public RunWinch(double s) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.elevator);

    speed = s;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.elevator.setAutoOverride(true);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.elevator.run(speed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.elevator.onTarget();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.elevator.run(0);
    Robot.elevator.setAutoOverride(false);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.elevator.run(0);
    Robot.elevator.setAutoOverride(false);
  }
}
