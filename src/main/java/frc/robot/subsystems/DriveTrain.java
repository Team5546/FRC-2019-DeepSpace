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

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  DifferentialDrive robotDrive;
  VictorSP leftFront, leftBack, rightFront, rightBack;
  SpeedControllerGroup left, right;

public DriveTrain() {
  VictorSP leftBack = new VictorSP(RobotMap.leftBackMotorChannel);
  VictorSP leftFront = new VictorSP(RobotMap.leftFrontMotorChannel);
  VictorSP rightBack = new VictorSP(RobotMap.rightBackMotorChannel);
  VictorSP rightFront = new VictorSP(RobotMap.rightFrontMotorChannel);
  left = new SpeedControllerGroup(leftBack, leftFront);
  right = new SpeedControllerGroup(rightBack, rightFront);
  robotDrive = new DifferentialDrive(left, right);
}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new Drive());
  }
  public void driveStickInputs(Joystick left, Joystick right) {
    robotDrive.tankDrive(left.getRawAxis(0), right.getRawAxis(0)); 
  }
  // public void stop() {
  //   robotDrive.tankDrive(0, 0);
  // }
}
