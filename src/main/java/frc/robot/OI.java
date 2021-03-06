/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.auto.Level3Climb;
import frc.robot.commands.auto.PlaceHatch;
import frc.robot.commands.auto.TakeHatch;
import frc.robot.commands.elevator.Calibrate;
import frc.robot.commands.elevator.Grab;
import frc.robot.commands.elevator.LetGo;

public class OI {
  // USB ports
  private final int LEFT_STICK_PORT = 0;
  private final int RIGHT_STICK_PORT = 1;

  // Controllers
  public Joystick leftStick = new Joystick(LEFT_STICK_PORT);
  public Joystick rightStick = new Joystick(RIGHT_STICK_PORT);

  public JoystickButton rightTrigger = new JoystickButton(rightStick, 1);
  public JoystickButton leftTrigger = new JoystickButton(leftStick, 1);

  public JoystickButton ballMode1 = new JoystickButton(leftStick, 3);
  public JoystickButton ballMode2 = new JoystickButton(leftStick, 4);

  public JoystickButton grab1 = new JoystickButton(rightStick, 3);
  public JoystickButton grab2 = new JoystickButton(rightStick, 4);

  public JoystickButton autoTest = new JoystickButton(rightStick, 12);

  // public JoystickButton driveClimb = new JoystickButton(leftStick, 1);

  public OI() {
    grab1.whenPressed(new Grab());
    grab2.whenPressed(new Grab());

    grab1.whenReleased(new LetGo());
    grab2.whenReleased(new LetGo());

    autoTest.whenPressed(new Level3Climb());
  }
}
