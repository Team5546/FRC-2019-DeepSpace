/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.elevator.Grab;
import frc.robot.commands.elevator.LetGo;
import frc.robot.commands.elevator.RunRelative;

public class TakeHatch extends CommandGroup {
  private static final double HEIGHT_PER_ROTATION = (1.25 * Math.PI) * 2;

  private static final double HATCH_OFFSET = 3 * HEIGHT_PER_ROTATION;

  public TakeHatch() {
    addSequential(new LetGo());
    addSequential(new RunRelative(HATCH_OFFSET), .5);
    addSequential(new Grab());
  }
}
