/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.DriveCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Drive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  CANSparkMax sparkBackRight;
  CANSparkMax sparkBackLeft;
  CANSparkMax sparkMidRight;
  CANSparkMax sparkMidLeft;
  WPI_TalonSRX talonFrontLeft;
  WPI_TalonSRX talonFrontRight;
  DifferentialDrive DriveFront;
  DifferentialDrive DriveMid;
  DifferentialDrive DriveBack;

  public Drive() {
    sparkBackRight = new CANSparkMax(RobotMap.sparkBR, MotorType.kBrushed);
    sparkBackLeft = new CANSparkMax(RobotMap.sparkBL, MotorType.kBrushed);
    sparkMidRight = new CANSparkMax(RobotMap.sparkMR, MotorType.kBrushed);
    sparkMidLeft = new CANSparkMax(RobotMap.sparkML, MotorType.kBrushed);

    talonFrontLeft = new WPI_TalonSRX(RobotMap.talonFL);
    talonFrontRight = new WPI_TalonSRX(RobotMap.talonFR);

    DriveFront = new DifferentialDrive(talonFrontLeft, talonFrontRight);
    DriveMid = new DifferentialDrive(sparkMidLeft, sparkMidRight);
    DriveBack = new DifferentialDrive(sparkBackLeft, sparkBackRight);
  }

  public void drive(Joystick a) {
    DriveFront.tankDrive(a.getRawAxis(RobotMap.lsYA), RobotMap.rsYA);
    DriveMid.tankDrive(a.getRawAxis(RobotMap.lsYA), RobotMap.rsYA);
    DriveBack.tankDrive(a.getRawAxis(RobotMap.lsYA), RobotMap.rsYA);
  }

  public void driveforward(double speed) {
    DriveFront.tankDrive(speed, speed);
    DriveMid.tankDrive(speed, speed);
    DriveBack.tankDrive(speed, speed);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveCommand());
  }
}
