/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.commands.PullyPIDCommand;
import com.revrobotics.CANEncoder;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.RobotMap;


/**
 * Add your docs here.
 */
public class PullyPIDSubsystem extends PIDSubsystem {
  /**
   * Add your docs here.
   */
  CANSparkMax sparkPully;
  public CANEncoder EncoderPully;
   

  public PullyPIDSubsystem() {
    // Intert a subsystem name and PID values here
    super("PullyPIDSubsystem", 1, 2, 3);
    sparkPully = new CANSparkMax(0, MotorType.kBrushless);
    EncoderPully = new CANEncoder(sparkPully);


    setAbsoluteTolerance(0.1);
    setInputRange(-2000, 2000);
    setOutputRange(-1, 1);
    getPIDController().setContinuous(true);

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new PullyPIDCommand());
  }

  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    return EncoderPully.getPosition();
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
    sparkPully.pidWrite(output);
  }
  double PullyPosition = 0;
  public void Drive(Joystick b) {
    Robot.PullyPID_Subsystem.enable();
    Robot.PullyPID_Subsystem.setSetpoint(PullyPosition);
    PullyPosition = PullyPosition + 5 * (b.getRawAxis(RobotMap.triggerRight) - b.getRawAxis(RobotMap.triggerLeft));


  }
}
