/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.climb.ClimbExtend;
import frc.robot.commands.climb.ClimbRetract;
import frc.robot.commands.elevator.SetHab3;

public class Level3Climb extends CommandGroup {
  /**
   * Add your docs here.
   */
  public Level3Climb() {
    addSequential(new ElevatorOverride());
    addSequential(new SetHab3(), 2);
    addSequential(new AutoDrive(), 2);
    addSequential(new ElevatorOverride());
    addParallel(new ClimbExtend());
    addParallel(new AutoDrive(), 10);
    addSequential(new ClimbDrive(), 3);
    addSequential(new ClimbRetract(), 2);
  }
}
