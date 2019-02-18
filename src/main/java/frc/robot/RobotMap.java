/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public class RobotMap {
  // PWM
  public static final int LEFT_FRONT_DRIVE = 0;
  public static final int LEFT_BACK_DRIVE = 1;
  public static final int RIGHT_FRONT_DRIVE = 2;
  public static final int RIGHT_BACK_DRIVE = 3;

  public static final int WINCH_MOTOR_1 = 4;
  public static final int WINCH_MOTOR_2 = 5;

  public static final int CLIMB_MOTOR_LEFT = 5;
  public static final int CLIMB_MOTOR_RIGHT = 5;

  // PCM
  public static final int ELEVATOR_TILT_SOLENOID = 0;
  public static final int ELEVATOR_LOCK_SOLENOID = 1;

  // DIO
  public static final int ELEVATOR_ENCODER = 0;
  public static final int CLIMB_LIMIT_DOWN = 1;
  public static final int CLIMB_LIMIT_UP = 2;
  public static final int ELEVATOR_LIMIT = 3;
}
