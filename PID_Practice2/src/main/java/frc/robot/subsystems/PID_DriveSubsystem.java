/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
/**
 * Add your docs here.
 */
public class PID_DriveSubsystem extends PIDSubsystem {
  /**
   * Add your docs here.
   */
  int P = 1;
  int I = 1;
  int D = 1;
  int integral = 1;
  int previous_error = 1;

  WPI_TalonFX Falcon1 = new WPI_TalonFX(0);
  WPI_TalonFX Falcon2 = new WPI_TalonFX(0); 
  WPI_TalonFX Falcon3 = new WPI_TalonFX(0);
  WPI_TalonFX Falcon4 = new WPI_TalonFX(0);
  Encoder encoder = new Encoder(0, 1, true, EncodingType.k4X);

  int setpoint = 1;
  public PID_DriveSubsystem() {
    // Intert a subsystem name and PID values here
    super("Drive", 1, 2, 3);
    setAbsoluteTolerance(0.05);
    setSetpoint(10);
    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.
    enable();
  }
  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    return 0.0;
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
  }
}
