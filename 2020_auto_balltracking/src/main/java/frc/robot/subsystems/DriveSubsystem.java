/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.TankDrive;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  CANSparkMax SparkA; // left mid
  CANSparkMax SparkB; // left back
  CANSparkMax SparkC; // right mid
  CANSparkMax SparkD; // right back
  WPI_TalonSRX TalonA; // right front
  WPI_TalonSRX TalonB; // left front
  DifferentialDrive frontDrive;
  DifferentialDrive midDrive;
  DifferentialDrive backDrive;

  public DriveSubsystem() {
    //Declaring Sparks
    SparkA = new CANSparkMax (RobotMap.SparkA, MotorType.kBrushed); // left mid
    SparkB = new CANSparkMax (RobotMap.SparkB, MotorType.kBrushed); // left back;
    SparkC = new CANSparkMax (RobotMap.SparkC, MotorType.kBrushed); // right mid
    SparkD = new CANSparkMax (RobotMap.SparkD, MotorType.kBrushed); // right back
    //Declaring Talons
    TalonA = new WPI_TalonSRX(RobotMap.TalonA);
    TalonB = new WPI_TalonSRX(RobotMap.TalonB);
    SparkA.setInverted(true);
    SparkB.setInverted(true);
    SparkC.setInverted(true);
    SparkD.setInverted(true);



    TalonA.setInverted(false);
    TalonB.setInverted(false);
    //Declaring DifferentialDrive
    frontDrive = new DifferentialDrive(TalonB, TalonA);
    midDrive = new DifferentialDrive(SparkA, SparkC);
    backDrive = new DifferentialDrive(SparkB, SparkD);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new TankDrive());
  }
  public void joystickDrive(Joystick a){
    frontDrive.tankDrive(a.getRawAxis(RobotMap.lsYA), a.getRawAxis(RobotMap.rsYA));
    midDrive.tankDrive(a.getRawAxis(RobotMap.lsYA), a.getRawAxis(RobotMap.rsYA));
    backDrive.tankDrive(a.getRawAxis(RobotMap.lsYA), a.getRawAxis(RobotMap.rsYA));
  }
  
  public void driveTurn(int direction, double turnSpeed, double forwardSpeed) {
    frontDrive.arcadeDrive(forwardSpeed, direction * turnSpeed);
    midDrive.arcadeDrive(forwardSpeed, direction * turnSpeed);
    backDrive.arcadeDrive(forwardSpeed, direction * turnSpeed);
  }
  
}
