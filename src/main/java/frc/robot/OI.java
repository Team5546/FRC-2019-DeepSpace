/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

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

  // public JoystickButton driveClimb = new JoystickButton(leftStick, 1);

  public OI() {
    //driveClimb.whenPressed();

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
  }
}
