/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;
import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  WPI_TalonSRX talonFL;
  WPI_TalonSRX talonFR;
  CANSparkMax sparkML;
  CANSparkMax sparkMR;
  CANSparkMax sparkBL;
  CANSparkMax sparkBR;

  DifferentialDrive Drive_Top;
  

  public DriveSubsystem() {
    talonFL = new WPI_TalonSRX(0);
    talonFR = new WPI_TalonSRX(0);
    sparkML = new CANSparkMax(0, MotorType.kBrushed);
    sparkMR = new CANSparkMax(0, MotorType.kBrushed);
    sparkBL = new CANSparkMax(0, MotorType.kBrushed);
    sparkBR = new CANSparkMax(0, MotorType.kBrushed);
    Drive_Top = new DifferentialDrive(talonFL, talonFR);
  }

  @Override
0  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveCommand());
  }

  public void Drive(Joystick a) {
    double leftSpeed = a.getRawAxis(RobotMap.lsYA);
    double rightSpeed = a.getRawAxis(RobotMap.rsYA);
    if(Math.abs(a.getRawAxis(RobotMap.lsYA)) < 0.05 ) {
      leftSpeed = 0;
    }
    if(Math.abs(a.getRawAxis(RobotMap.rsYA)) < 0.05 ) {
      rightSpeed = 0;
    }
    Drive_Top.tankDrive(leftSpeed, rightSpeed);
    sparkML.set(leftSpeed);
    sparkBL.set(leftSpeed);
    sparkMR.set(rightSpeed);
    sparkBR.set(rightSpeed);
  }
}
