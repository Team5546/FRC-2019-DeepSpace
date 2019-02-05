/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DiskLevel extends Command {
  int target;
  boolean finished;
  double distance;
  double speed;

  public DiskLevel(int pos, int spd) {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.elevator);
    target = pos;
    speed = spd;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //TEMPORARY NUMBERS
    if(target == 1) {
      Robot.elevator.setSetpoint(12.5);
    }else if(target == 2) {
      Robot.elevator.setSetpoint(2000);
    }else if(target == 3) {
      Robot.elevator.setSetpoint(3000);
    }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
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
