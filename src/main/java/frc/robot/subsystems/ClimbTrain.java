/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class ClimbTrain extends Subsystem {
  private VictorSP climbWheel;

  public boolean override = false;

  public ClimbTrain() {
    climbWheel = new VictorSP(RobotMap.CLIMB_DRIVE);
  }

  public void driveForward() {
    climbWheel.set(-.75);
    return;
  }

  public void driveStop() {
    climbWheel.set(0);
    return;
  }

  public void driveRun(double speed) {
    climbWheel.set(speed);
    return;
  }

  public void setOverride(boolean o) {
    override = o;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
