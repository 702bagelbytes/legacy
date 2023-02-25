/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;
import frc.robot.RobotMap;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.commands.DriveCommand;


/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  CANSparkMax BL;
  CANSparkMax BR;
  CANSparkMax ML;
  CANSparkMax MR;
  WPI_TalonSRX FL;
  WPI_TalonSRX FR;
  DifferentialDrive DB;
  DifferentialDrive DM;
  DifferentialDrive DF;

  public DriveSubsystem() {
    BL = new CANSparkMax(RobotMap.SparkBL, MotorType.kBrushed);
    BR = new CANSparkMax(RobotMap.SparkBR, MotorType.kBrushed);
    ML = new CANSparkMax(RobotMap.SparkML, MotorType.kBrushed);
    MR = new CANSparkMax(RobotMap.SparkMR, MotorType.kBrushed);
    FL = new WPI_TalonSRX(RobotMap.TalonFL);
    FR = new WPI_TalonSRX(RobotMap.TalonFR);
    DB = new DifferentialDrive(BL, BR);
    DM = new DifferentialDrive(ML, MR);
    DF = new DifferentialDrive(FL, FR);
  }

  public void drive() {
    boolean greenPressed = Robot.m_oi.getGreenButton().get();
    boolean redPressed = Robot.m_oi.getGreenButton().get();
    boolean yellowPressed = Robot.m_oi.getGreenButton().get();
    boolean bluePressed = Robot.m_oi.getGreenButton().get();
    double turnSpeed = 0;
    double forwardSpeed = 0;
    if(greenPressed) {
      forwardSpeed -= 0.5;
    }
    if(yellowPressed) {
      forwardSpeed +=0.5;
    }
    if (redPressed) {
      turnSpeed += 0.5;
    }
    if (bluePressed) {
      turnSpeed -= 0.5;
    }
    DB.arcadeDrive(forwardSpeed, turnSpeed);
    DB.arcadeDrive(forwardSpeed, turnSpeed);
    DB.arcadeDrive(forwardSpeed, turnSpeed);

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveCommand());
  }
}
