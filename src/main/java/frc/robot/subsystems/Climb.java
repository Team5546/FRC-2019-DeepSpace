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

import frc.robot.commands.climb.ClimbExtend;
import frc.robot.commands.climb.Stop;

/**
 * Add your docs here.
 */
public class Climb extends Subsystem {
  private VictorSP climbLeft, climbRight, climbWheel;
  DifferentialDrive climbDrive;
  private DigitalInput downLimit;
  private DigitalInput upLimit;

  private static final double SPEED = 0.5;

  public boolean override = false;

  public Climb() {
    climbLeft = new VictorSP(RobotMap.CLIMB_MOTOR_LEFT);
    climbRight = new VictorSP(RobotMap.CLIMB_MOTOR_RIGHT);
    climbDrive = new DifferentialDrive(climbLeft, climbRight);
    climbWheel = new VictorSP(RobotMap.CLIMB_DRIVE);

    downLimit = new DigitalInput(RobotMap.CLIMB_LIMIT_DOWN);
    upLimit = new DigitalInput(RobotMap.CLIMB_LIMIT_UP);
    //climbDrive.tankDrive(0, 0);
  }

  public void down() {
    System.out.println("Down");
    climbDrive.tankDrive(SPEED, SPEED);
    return;
  }

  public void up() {
    System.out.println("Up");
    climbDrive.tankDrive(-SPEED, -SPEED);
    return;
  }

  public void stop() {
    //System.out.println("Stop");
    climbDrive.tankDrive(0, 0);
  }

  public boolean getUp() {
    return !upLimit.get();
  }

  public boolean getDown() {
    return !downLimit.get();
  }

  public void runForce(double speed) {
    //System.out.println("Speed: " + climbDrive);
    override = true;
    climbDrive.tankDrive(speed, speed);
    //climbLeft.set(speed);
    //climbRight.set(-speed);
    return;
  }

  public void driveForward() {
    climbWheel.set(-1);
    return;
  }

  public void driveStop() {
    climbWheel.set(0);
    return;
  }

  public void toggleOverride() {
    override = !override;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new Stop());
  }
}
