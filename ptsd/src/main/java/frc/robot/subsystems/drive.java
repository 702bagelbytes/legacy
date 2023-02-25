/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.SparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.util.WPILibVersion;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


/**
 * Add your docs here.
 */
public class drive extends Subsystem {
  WPI_TalonSRX frontLeft; 
  WPI_TalonSRX frontRight;
  WPI_TalonSRX backLeft;
  WPI_TalonSRX backRight; 
  DifferentialDrive frontDrive;
  DifferentialDrive backDrive; 
  CANSparkMax arm;

  
  public drive(){
    frontLeft = new WPI_TalonSRX(0);
    frontRight = new WPI_TalonSRX(0);
    backLeft = new WPI_TalonSRX(0);
    backRight = new WPI_TalonSRX(0);
    arm = new CANSparkMax(0, MotorType.kBrushed);
    frontDrive = new DifferentialDrive(frontLeft, frontRight);
    backDrive = new DifferentialDrive(backLeft, backRight);
  }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public drive(Joystick joy){
    frontDrive.tankDrive(joy.getRawAxis(0), joy.getRawAxis(0)); 
    backDrive.tankDrive(joy.getRawAxis(0), joy.getRawAxis(0));
    arm.set(0);
  }
}
