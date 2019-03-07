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
  public Level3Climb() {
    // Raise Elevator to Level 3 Height
    //addSequential(new ElevatorOverride());
    addSequential(new SetHab3(), 10);
    // Drive Forward to put manipulator on platform
    addSequential(new AutoDrive(), 2);
    // Make Elevator Go Down
    //addParallel(new ElevatorOverride());
    // Extend Legs
    addParallel(new ClimbExtend(), 2);
    // Slowly drive with main wheels
    addParallel(new AutoDrive(), 10);
    // Drive with leg wheels
    addSequential(new ClimbDrive(), 3);
    // Raise legs once on platform
    addSequential(new ClimbRetract(), 2);
  }
}
