 // Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  WPI_TalonSRX TALON_FL;
  WPI_TalonSRX TALON_FR;
  WPI_TalonSRX TALON_BL;
  WPI_TalonSRX TALON_BR;
 /* CANSparkMax SPARK_ML;
  CANSparkMax SPARK_MR;
  CANSparkMax SPARK_BL;
  CANSparkMax SPARK_BR;
*/
  DifferentialDrive frontDrive;
 // DifferentialDrive middleDrive;
  DifferentialDrive backDrive;

  public DriveSubsystem() {
    TALON_FL = new WPI_TalonSRX(Constants.TALONFL);
    TALON_FR = new WPI_TalonSRX(Constants.TALONFR);
    TALON_BL = new WPI_TalonSRX(Constants.TALONBL);
    TALON_BR = new WPI_TalonSRX(Constants.TALONBR);

    /*SPARK_ML = new CANSparkMax(Constants.SPARK_ML, MotorType.kBrushed);
    SPARK_MR = new CANSparkMax(Constants.SPARK_MR, MotorType.kBrushed);
    SPARK_BL = new CANSparkMax(Constants.SPARK_BL, MotorType.kBrushed);
    SPARK_BR = new CANSparkMax(Constants.SPARK_BR, MotorType.kBrushed);
*/
    frontDrive = new DifferentialDrive(TALON_FL, TALON_FR);
   // middleDrive = new DifferentialDrive(SPARK_ML, SPARK_MR);
    backDrive = new DifferentialDrive(TALON_BL, TALON_BR);
/*
    SPARK_ML.setInverted(true);
    SPARK_MR.setInverted(true);
  */}

  public void setRight(double speed){
    TALON_FR.set(-speed * Constants.DRIVESPEEDCONSTANT);
    TALON_BR.set(-speed * Constants.DRIVESPEEDCONSTANT);

    /*SPARK_MR.set(-speed * Constants.DRIVESPEEDCONSTANT);
    SPARK_BR.set(-speed * Constants.DRIVESPEEDCONSTANT);*/
  }

  public void setLeft(double speed){
    TALON_FL.set(speed * Constants.DRIVESPEEDCONSTANT);
    TALON_BL.set(speed * Constants.DRIVESPEEDCONSTANT);

   /* SPARK_ML.set(speed * Constants.DRIVESPEEDCONSTANT);
    SPARK_BL.set(speed * Constants.DRIVESPEEDCONSTANT);*/
  }

  public void setSpeed(double speed){
    frontDrive.tankDrive(speed * Constants.AUTOSPEEDCONTANT, speed * Constants.AUTOSPEEDCONTANT);
    //middleDrive.tankDrive(speed * Constants.AUTOSPEEDCONTANT, speed * Constants.AUTOSPEEDCONTANT);
    backDrive.tankDrive(speed * Constants.AUTOSPEEDCONTANT, speed * Constants.AUTOSPEEDCONTANT);
  }

  public void tankdrive(XboxController joy){
    double leftspeed = -joy.getRawAxis(Constants.LEFTSTICK_YAXIS) * Constants.DRIVESPEEDCONSTANT;
    double rightspeed = -joy.getRawAxis(Constants.RIGHTSTICK_YAXIS) * Constants.DRIVESPEEDCONSTANT;

    
    frontDrive.tankDrive(leftspeed, rightspeed);
    //middleDrive.tankDrive(leftspeed, rightspeed);
    backDrive.tankDrive(leftspeed, rightspeed);

  } 

  public void arcadedrive(XboxController joy){
    double accel = joy.getRawAxis(Constants.LEFTSTICK_YAXIS);
    double turn = joy.getRawAxis(Constants.RIGHTSTICK_XAXIS);

    
    frontDrive.arcadeDrive(accel, turn);
    //middleDrive.tankDrive(accel, turn);
    backDrive.tankDrive(accel, turn);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}