/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.robot.commands.climb.ClimbRetract;
import frc.robot.commands.gyro.GyroClimb;

public class Level2Climb extends CommandGroup {
  
  int liftTime = 2;
  int driveTime = 3;

  public Level2Climb() {
    addParallel(new GyroClimb(), liftTime);
    addSequential(new WaitCommand(0.5));
    addParallel(new ClimbDrive(), driveTime);
    addSequential(new WaitCommand(driveTime + 0.25));
    addSequential(new ClimbRetract(), .25);
  }
}
