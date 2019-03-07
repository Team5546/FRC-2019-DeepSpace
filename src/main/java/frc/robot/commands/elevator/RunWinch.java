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
  private static final double HEIGHT_PER_ROTATION = (1.25 * Math.PI) * 2;

  private static final double LEVEL_1 = 12.5 * HEIGHT_PER_ROTATION;
  private static final double LEVEL_2 = 30.5 *HEIGHT_PER_ROTATION;
  private static final double LEVEL_3 = 58.5 * HEIGHT_PER_ROTATION;

  private static final double BALL_LEVEL_1 = 21 * HEIGHT_PER_ROTATION;
  private static final double BALL_LEVEL_2 = 49 * HEIGHT_PER_ROTATION;
  private static final double BALL_LEVEL_3 = 77 * HEIGHT_PER_ROTATION;

  public RunWinch() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.elevator);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.elevator.enable();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (!Robot.elevator.isOverriden()) {
      // Ball Levels
      if (Robot.oi.ballMode1.get() || Robot.oi.ballMode2.get()) {
        // Right Trigger Pressed
        if (Robot.oi.rightTrigger.get()) {
          // Both Triggers Pressed
          if (Robot.oi.leftTrigger.get())
            
            Robot.elevator.setSetpoint(BALL_LEVEL_3);
          // Only Right Trigger Pressed
          else
            Robot.elevator.setSetpoint(BALL_LEVEL_1);
        }
        // Left Trigger Pressed
        else if (Robot.oi.leftTrigger.get())
          Robot.elevator.setSetpoint(BALL_LEVEL_2);
        // No Triggers Pressed
        else
          Robot.elevator.setSetpoint(0);
      }
      // Hatch Levels
      else {
        // Right Trigger Pressed
        if (Robot.oi.rightTrigger.get()) {
          // Both Triggers Pressed
          if (Robot.oi.leftTrigger.get())
            Robot.elevator.setSetpoint(LEVEL_3);
          // Only Right Trigger Pressed
          else
            Robot.elevator.setSetpoint(LEVEL_1);
        }
        // Left Trigger Pressed
        else if (Robot.oi.leftTrigger.get())
          Robot.elevator.setSetpoint(LEVEL_2);
        // No Triggers Pressed
        else
          Robot.elevator.setSetpoint(0);
      }
      //System.out.println(Robot.oi.rightStick.getTrigger());
      System.out.print("\nSetpoint: " + Robot.elevator.getSetpoint());
      System.out.print("\tPosition: " + Robot.elevator.getPosition());
      System.out.print("\tPosition - Setpoint: " + (Robot.elevator.getPosition() - Robot.elevator.getSetpoint()));
    //   if (Robot.oi.rightStick.getTrigger()) {
    //     Robot.elevator.setSetpoint(1);
    //     Robot.elevator.enable();
    //   }
    //   else Robot.elevator.disable();

      // Enable to go to setpoint
      Robot.elevator.setAbsoluteTolerance(500);
      //Robot.elevator.enable();
    }
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
