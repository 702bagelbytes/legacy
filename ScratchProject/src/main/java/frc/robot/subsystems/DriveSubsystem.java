/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;

/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  CANSparkMax sparkBackLeft;
  CANSparkMax sparkBackRight;
  CANSparkMax sparkMidLeft;
  CANSparkMax sparkMidRight;
  WPI_TalonSRX talonFrontLeft;
  WPI_TalonSRX talonFrontRight;
  DifferentialDrive front;
  DifferentialDrive mid;
  DifferentialDrive back;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public DriveSubsystem() {
    sparkBackLeft = new CANSparkMax(RobotMap.sparkBL, MotorType.kBrushed);
    sparkBackRight = new CANSparkMax(RobotMap.sparkBR, MotorType.kBrushed);
    sparkMidLeft = new CANSparkMax(RobotMap.sparkML, MotorType.kBrushed);
    sparkMidRight = new CANSparkMax(RobotMap.sparkMR, MotorType.kBrushed);
    talonFrontLeft = new WPI_TalonSRX(RobotMap.talonFL);
    talonFrontRight = new WPI_TalonSRX(RobotMap.talonFR);
    front = new DifferentialDrive(talonFrontLeft, talonFrontRight);
    mid = new DifferentialDrive(sparkMidLeft, sparkMidRight);
    back = new DifferentialDrive(sparkBackLeft, sparkBackRight);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void drive(Joystick joy) {
    front.tankDrive(joy.getRawAxis(RobotMap.lsYA), joy.getRawAxis(RobotMap.rsYA));
    mid.tankDrive(joy.getRawAxis(RobotMap.lsYA), joy.getRawAxis(RobotMap.rsYA));
    back.tankDrive(joy.getRawAxis(RobotMap.lsYA), joy.getRawAxis(RobotMap.rsYA));
  }

  public void driveForward(double speed) {
    front.tankDrive(speed, speed);
    mid.tankDrive(speed, speed);
    back.tankDrive(speed , speed);
  }
}
