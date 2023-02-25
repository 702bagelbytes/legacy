/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.commands.driveCommandPID;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/**
 * Add your docs here.
 */
public class driveSubsystemPID extends PIDSubsystem {
  /**
   * Add your docs here.
   */
  CANSparkMax Spark1;
  CANEncoder EncoderSpark;
  // CanSparkMax FrontL;
  // CANSparkMax FrontR;
  // CANSparkMax BackL;
  // CANSparkMax BackR;
  // MecanumDrive single;
  // MecanumDrive frontDrive;
  // MecanumDrive backDrive;

  public driveSubsystemPID() {
    // Intert a subsystem name and PID values here
    super("driveSubsystemPID", 1, 2, 3);
    Spark1 = new CANSparkMax(13, MotorType.kBrushless);
    EncoderSpark = new CANEncoder(Spark1);
    // single = new MecanumDrive(FrontL, FrontL, FrontL, FrontL);
    // FrontL = new CANSparkMax(0, MotorType.kBrushless);
    // FrontR = new CANSparkMax(0, MotorType.kBrushless);
    // BackL = new CANSparkMax(0, MotorType.kBrushless);
    // BackR = new CANSparkMax(0, MotorType.kBrushless);
    setAbsoluteTolerance(0.5);
    setInputRange(-2000, 2000);
    setOutputRange(-1, 1);
    getPIDController().setContinuous(false);
    // setSetpoint(16400);
    // enable();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new driveCommandPID());
  }

  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    return EncoderSpark.getPosition();
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
    Spark1.pidWrite(output);
  }
}
