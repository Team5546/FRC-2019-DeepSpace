/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RunManual extends Command {
  public RunManual() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.elevator);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.elevator.disable();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double twist = Robot.oi.leftStick.getTwist();
    if (twist > 0.5 || twist < -0.5) {
      if (DriverStation.getInstance().getMatchTime() > 30) {
        Robot.elevator.run(-twist * 0.75);
      }
      else {
        Robot.elevator.run(-twist);
      }
    }
    else Robot.elevator.run(0);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
