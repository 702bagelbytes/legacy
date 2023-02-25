/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

/************************************************************************************
 * THINGS TO IMPORT:
 * - cansparkmax
 * - encoders
 * - pid subsystem
************************************************************************************/
package frc.robot.subsystems;
import frc.robot.commands.ClawPIDCommand;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import com.revrobotics.CANEncoder;

/**
 * Add your docs here.
 */
public class ClawPIDSubsystem extends PIDSubsystem {
  /**
   * Add your docs here.
   */
  CANSparkMax sparkClaw;
  public CANEncoder sparkEncoder;

  public ClawPIDSubsystem() {
    // Intert a subsystem name and PID values here
    super("ClawPIDSubsystem", 1, 2, 3);
    sparkClaw = new CANSparkMax(13, MotorType.kBrushless);
    sparkEncoder = new CANEncoder(sparkClaw);

    setAbsoluteTolerance(1);
    setInputRange(-2000, 2000);
    setOutputRange(-0.05, 0.05);
    getPIDController().setContinuous(true);

    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.
  }



  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new ClawPIDCommand());
  }

  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    sparkEncoder.setPosition(0);
    return sparkEncoder.getPosition();
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor 
    // e.g. yourMotor.set(output);
    sparkClaw.pidWrite(output); 
    
  }
}
