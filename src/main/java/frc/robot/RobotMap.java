/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public class RobotMap {
  // PWM
  public static final int LEFT_FRONT_DRIVE = 6;
  public static final int LEFT_BACK_DRIVE = 7;
  public static final int RIGHT_FRONT_DRIVE = 4;
  public static final int RIGHT_BACK_DRIVE = 5;

  public static final int WINCH_MOTOR_1 = 2;
  public static final int WINCH_MOTOR_2 = 3;
  public static final int MANIPULATOR = 9;

  public static final int CLIMB_MOTOR_LEFT = 0;
  public static final int CLIMB_MOTOR_RIGHT = 1;
  public static final int CLIMB_DRIVE = 8;

  // PCM
  public static final int ELEVATOR_TILT_SOLENOID_1 = 0;
  public static final int ELEVATOR_TILT_SOLENOID_2 = 1;
  public static final int MANIPULATOR_SOLENOID_1 = 7;
  public static final int MANIPULATOR_SOLENOID_2 = 3;

  // DIO
  public static final int ELEVATOR_ENCODER_1 = 0;
  public static final int ELEVATOR_ENCODER_2 = 1;
  public static final int CLIMB_LIMIT_DOWN = 2;
  public static final int CLIMB_LIMIT_UP = 3;
}
