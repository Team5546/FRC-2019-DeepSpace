/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.robot.commands.climb.ClimbExtend;
import frc.robot.commands.climb.ClimbRetract;
import frc.robot.commands.elevator.RunWinch;
import frc.robot.commands.gyro.GyroClimb;

public class Level3Climb extends CommandGroup {

  int liftTime = 6;
  int driveTime = 3;

  public Level3Climb() {
    addParallel(new GyroClimb(), liftTime);
    addSequential(new WaitCommand(3.5));
    addParallel(new ClimbDrive(), driveTime);
    addSequential(new WaitCommand(driveTime + 1));
    addSequential(new ClimbRetract(), 1);
  }
}
