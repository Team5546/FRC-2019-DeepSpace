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
  // Define hatch heights in inches
  private static final double LEVEL_1 = 12.5;
  private static final double LEVEL_2 = 30.5;
  private static final double LEVEL_3 = 58.5;

  int target;

  public DiskLevel(int pos) {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.elevator);
    target = pos;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    // Heights need testing
    if (target == 1)
      Robot.elevator.setSetpoint(LEVEL_1);
    else if (target == 2)
      Robot.elevator.setSetpoint(LEVEL_2);
    else if (target == 3)
      Robot.elevator.setSetpoint(LEVEL_3);
    Robot.elevator.enable();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.elevator.onTarget();
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
