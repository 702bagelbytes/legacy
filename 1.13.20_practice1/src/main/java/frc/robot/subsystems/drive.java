/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.CAN;


/**
 * Add your docs here.
 */

public class drive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  WPI_TalonSRX frontL;
  WPI_TalonSRX frontR; 

  CANSparkMax midL; 
  CANSparkMax midR;
  CANSparkMax backL;
  CANSparkMax backR;

  DifferentialDrive frontDrive;
  DifferentialDrive midDrive;
  DifferentialDrive backDrive;


  public drive(){
    frontL = new WPI_TalonSRX(0);
    frontR = new WPI_TalonSRX(0);

    midL = new CANSparkMax(0,MotorType.kBrushed);
    midR = new CANSparkMax(0,MotorType.kBrushed);
    backL = new CANSparkMax(0,MotorType.kBrushed);
    backR = new CANSparkMax(0,MotorType.kBrushed);

    frontDrive = new DifferentialDrive(frontL, frontR);
    midDrive = new DifferentialDrive(midL, midR);
    backDrive = new DifferentialDrive(backL, backR);

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void teleop(){
    frontDrive.tankDrive(0, 0);
    midDrive.tankDrive(0, 0);
    backDrive.tankDrive(0, 0);
  }

  public void driveforward(double speed){
    frontDrive.tankDrive(speed, speed);
    midDrive.tankDrive(speed, speed);
    backDrive.tankDrive(speed, speed);    
  }

  public void driveStop(){
    frontDrive.tankDrive(0, 0);
    midDrive.tankDrive(0, 0);
    backDrive.tankDrive(0, 0);    
  }
}
