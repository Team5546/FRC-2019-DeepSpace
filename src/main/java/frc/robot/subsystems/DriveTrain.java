/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;

import frc.robot.RobotMap;
import frc.robot.commands.drivetrain.Drive;

public class DriveTrain extends Subsystem {
  private DifferentialDrive drive;
  private VictorSP leftFront, leftBack, rightFront, rightBack;
  private SpeedControllerGroup left, right;

  private boolean autoOverride = false;

  public DriveTrain() {
    leftBack = new VictorSP(RobotMap.LEFT_BACK_DRIVE);
    leftFront = new VictorSP(RobotMap.LEFT_FRONT_DRIVE);
    rightBack = new VictorSP(RobotMap.RIGHT_BACK_DRIVE);
    rightFront = new VictorSP(RobotMap.RIGHT_FRONT_DRIVE);

    left = new SpeedControllerGroup(leftBack, leftFront);
    right = new SpeedControllerGroup(rightBack, rightFront);

    drive = new DifferentialDrive(left, right);
  }

  public void driveSticks(Joystick left, Joystick right) {
    //System.out.println(right.getRawAxis(1));
    drive.tankDrive(-left.getRawAxis(1), -right.getRawAxis(1));
    return;
  }
  
  public void driveSpeed(double speed) {
    drive.tankDrive(speed, speed);
    return;
  }

  public boolean isOverriden() {
    return autoOverride;
  }

  public void setAutoOverride(boolean value) {
    autoOverride = value;
    return;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new Drive());
  }
}
