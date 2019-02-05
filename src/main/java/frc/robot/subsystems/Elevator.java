/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

// import edu.wpi.first.wpilibj.command.Subsystem;
// import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.RobotMap;
import frc.robot.commands.elevator.CheckSwitch;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Counter;
// import edu.wpi.first.wpilibj.Encoder;


/**
 * Add your docs here.
 */
public class Elevator extends PIDSubsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public DigitalInput limitSwitch;
  // public Encoder elevatorEncoder;
  public Counter switchCounter, elevatorEncoder;
  //Currently arbitrary value
  public final double distancePerFoot = 1000;
  
  PWMVictorSPX winchMotor;

  public Elevator() {
    //currently copied values from last year for Super
    super(4.0, 0.1, 0.0);
    winchMotor = new PWMVictorSPX(RobotMap.winchMotor);
    limitSwitch = new DigitalInput(RobotMap.winchLimitSwitch);
    switchCounter = new Counter(limitSwitch);
    elevatorEncoder = new Counter(RobotMap.elevatorEncoder);
    elevatorEncoder.setDistancePerPulse(distancePerFoot);
    // winchCounter = new Counter();
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new CheckSwitch());
  }
  //runs the winch motor until motor speed set to something different
  public void run(double spd) {
    winchMotor.set(spd);
  }
  //sets the winch to a specific height
  public void goTo(int pos) {
    if(pos == 1) {

    }else if(pos == 2) {

    }else if(pos == 3) {

    }
  }
  protected double returnPIDInput() {
    return elevatorEncoder.getDistance();
  }
  protected void usePIDOutput(double output) {
   
  }
}
