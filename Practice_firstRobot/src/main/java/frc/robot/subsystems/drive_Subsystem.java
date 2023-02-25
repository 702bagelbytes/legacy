/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;
import frc.robot.commands.Joystick_Drive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;

/**
 * Add your docs here.
 */
public class drive_Subsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
 
  WPI_TalonSRX talonFL;
  WPI_TalonSRX talonFR;
  WPI_TalonSRX talonML;
  WPI_TalonSRX talonMR;
  WPI_TalonSRX talonBL;
  WPI_TalonSRX talonBR;
  /*
  DifferentialDrive Drive_Top;
  DifferentialDrive Drive_Mid;
  DifferentialDrive Drive_Bottom;
  */
  MecanumDrive Drive_Mechanum;
  

  public drive_Subsystem() {
    talonFL = new WPI_TalonSRX(RobotMap.talonFL);
    talonFR = new WPI_TalonSRX(RobotMap.talonFR);
    talonML = new WPI_TalonSRX(RobotMap.talonML);
    talonMR = new WPI_TalonSRX(RobotMap.talonMR);
    talonBL = new WPI_TalonSRX(RobotMap.talonBL);
    talonBR = new WPI_TalonSRX(RobotMap.talonBR);
    /*
    Drive_Top = new DifferentialDrive(talonFL, talonFR);
    Drive_Mid = new DifferentialDrive(talonML, talonMR);
    Drive_Bottom = new DifferentialDrive(talonBL, talonBR);
    */
    Drive_Mechanum = new MecanumDrive(talonFL, talonFR, talonBL, talonBR);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new Joystick_Drive());
  }

  double leftSpeed = 0.0;
  double rightSpeed = 0.0;
  double leftY = 0;
  double leftX = 0;
  double finalLeft = 0;
  double finalRight = 0;
  double triggerRightOn;

  public void drive(Joystick a){  
/*----------------------------------------------------------------------------*/
/*                      FOR MECHANUM DRIVE                                    */
/*----------------------------------------------------------------------------*/
    Drive_Mechanum.driveCartesian(a.getRawAxis(RobotMap.lsYA), a.getRawAxis(RobotMap.lsXA), a.getRawAxis(RobotMap.rsXA));
/*----------------------------------------------------------------------------*/
/*                       FOR TRIGGER DRIVE                                    */
/*----------------------------------------------------------------------------*/
    /*
    triggerRightOn = 0;
    
    if (a.getRawAxis(RobotMap.triggerRight) > 0.05 ) {
      //triggerRightOn = 1;

      triggerRightOn = 1*a.getRawAxis(RobotMap.triggerRight);
    } else if (a.getRawAxis(RobotMap.triggerLeft) > 0.05){
      //triggerRightOn = -1;deploy

      triggerRightOn = -1*a.getRawAxis(RobotMap.triggerLeft);
    } else {
      triggerRightOn = 0;
    }
    leftY = 1*a.getRawAxis(RobotMap.lsYA);
    leftX = 1*a.getRawAxis(RobotMap.lsXA);
    if (Math.abs(leftX) < 0.2) {
      leftX = 0;
    }
    if (Math.abs(leftY) < 0.2) {
      leftY = 0;
    }
    if(triggerRightOn != 0) {
      finalLeft = triggerRightOn*(1+leftX);
      finalRight = triggerRightOn*(1-leftX);
    } else if (Math.abs(a.getRawAxis(RobotMap.lsXA)) > 0.05){
      finalLeft = 1 * leftX;
      finalRight = -1 * leftX;

    } else {
      finalLeft = 0;
      finalRight = 0;

    }


    Drive_Top.tankDrive(finalLeft,finalRight);
    Drive_Mid.tankDrive(finalLeft, finalRight);
    Drive_Bottom.tankDrive(finalLeft, finalRight);
    */

/*----------------------------------------------------------------------------*/
/*                             FOR NORMAL                                     */
/*----------------------------------------------------------------------------*/
    /*
    Drive_Top.tankDrive(-1*a.getRawAxis(RobotMap.lsYA), -1*a.getRawAxis(RobotMap.rsYA));
    Drive_Mid.tankDrive(-1*a.getRawAxis(RobotMap.lsYA), -1*a.getRawAxis(RobotMap.rsYA));
    Drive_Bottom.tankDrive(-1*a.getRawAxis(RobotMap.lsYA), -1*a.getRawAxis(RobotMap.rsYA));
    */


  }
}
