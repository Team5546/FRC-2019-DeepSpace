/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Climb extends Subsystem {
  private VictorSP climbLeft;
  private VictorSP climbRight;
  private DifferentialDrive climbDrive;
  private DigitalInput downLimit;
  private DigitalInput upLimit;

  private static final double SPEED = 0.5;

  public void climb() {
    climbLeft = new VictorSP(RobotMap.CLIMB_MOTOR_LEFT);
    climbRight = new VictorSP(RobotMap.CLIMB_MOTOR_RIGHT);
    climbDrive = new DifferentialDrive(climbLeft, climbRight);

    downLimit = new DigitalInput(RobotMap.CLIMB_LIMIT_DOWN);
    upLimit = new DigitalInput(RobotMap.CLIMB_LIMIT_UP);
  }

  public void down() {
    climbDrive.tankDrive(SPEED, SPEED);
    return;
  }

  public void up() {
    climbDrive.tankDrive(-SPEED, -SPEED);
    return;
  }

  public void stop() {
    climbDrive.tankDrive(0, 0);
  }

  public boolean getUp() {
    return !upLimit.get();
  }

  public boolean getDown() {
    return !downLimit.get();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
