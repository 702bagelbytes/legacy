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
import frc.robot.RobotMap;
import frc.robot.commands.Joystick_Drive;
import jdk.jshell.Diag;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrame;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class Drive_Subsystem extends Subsystem {
  WPI_TalonSRX talon1;
  DifferentialDrive drive_talon1;
  //WPI_TalonSRX motorFL;
  WPI_TalonSRX motorFR;
  WPI_TalonSRX motorML;
  WPI_TalonSRX motorMR;
  WPI_TalonSRX motorBL;
  WPI_TalonSRX motorBR;

  DifferentialDrive drive_top;
  DifferentialDrive drive_mid;
  DifferentialDrive drive_bot;

  public Drive_Subsystem (){
    super();
    talon1 = new WPI_TalonSRX (RobotMap.talonFL);
    drive_talon1 = new DifferentialDrive(talon1, talon1);

    //motorFL = new WPI_TalonSRX (RobotMap.talonFL);
    motorFR = new WPI_TalonSRX (RobotMap.talonFR);
    motorML = new WPI_TalonSRX (RobotMap.talonML);
    motorMR = new WPI_TalonSRX (RobotMap.talonMR);
    motorBL = new WPI_TalonSRX (RobotMap.talonBL);
    motorBR = new WPI_TalonSRX (RobotMap.talonBR);
    //drive_top = new DifferentialDrive(motorFL, motorFR);
    drive_mid = new DifferentialDrive(motorML, motorMR);
    drive_bot = new DifferentialDrive(motorBL, motorBR);
    talon1.setStatusFramePeriod(StatusFrame.Status_2_Feedback0, 10);
    talon1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
    talon1.setSelectedSensorPosition(0);
  }
  /*public void drive (Joystick xbox){
   drive_top.tankDrive(-0.5*xbox.getRawAxis(RobotMap.leftStickY_Axis),-0.5*xbox.getRawAxis(RobotMap.rightStickY_Axis));
   drive_mid.tankDrive(-0.5*xbox. getRawAxis(RobotMap.leftStickY_Axis),-0.5*xbox.getRawAxis(RobotMap.rightStickY_Axis));
   drive_bot.tankDrive(-0.5*xbox.getRawAxis(RobotMap.leftStickY_Axis),-0.5*xbox.getRawAxis(RobotMap.rightStickY_Axis));
  */
  /*public void drive (Joystick xbox){
    drive_top.tankDrive(xbox.getRawAxis(RobotMap.triggerLeft),xbox.getRawAxis(RobotMap.triggerRight));
    drive_mid.tankDrive(xbox.getRawAxis(RobotMap.triggerLeft),xbox.getRawAxis(RobotMap.triggerRight));
    drive_bot.tankDrive(xbox.getRawAxis(RobotMap.triggerLeft),xbox.getRawAxis(RobotMap.triggerRight)); 
  */

    int driving = 0;
  public void drive (Joystick xbox){ 
    /*
    drive_top.tankDrive(-1*xbox.getRawAxis(RobotMap.leftStickY_Axis),-1*xbox.getRawAxis(RobotMap.rightStickY_Axis));
    drive_mid.tankDrive(-1*xbox.getRawAxis(RobotMap.leftStickY_Axis),-1*xbox.getRawAxis(RobotMap.rightStickY_Axis));
    drive_bot.tankDrive(-1*xbox.getRawAxis(RobotMap.leftStickY_Axis),-1*xbox.getRawAxis(RobotMap.rightStickY_Axis));
    */
    double howMuchWeNeedToRotate = 12/(4*3.14) * 4096; 
    if(xbox.getRawButton(RobotMap.buttonA) && driving == 0) {
      driving = 1;
      talon1.setSelectedSensorPosition(0);
    }
    if(driving == 1) {
      //drive_talon1.tankDrive(-0.4,-0.4);
      drive_top.tankDrive(0.5,0.5);
      drive_mid.tankDrive(0.5,0.5);
      drive_bot.tankDrive(0.5,0.5);

      if(talon1.getSelectedSensorPosition() >= -1 * howMuchWeNeedToRotate) {
        driving = 0;
        talon1.setSelectedSensorPosition(0);
      }
    }
    /*
    if(driving == 2) {
      drive_talon1.tankDrive(0.4,0.4);
      if(talon1.getSelectedSensorPosition() < -4096) {
        talon1.setSelectedSensorPosition(0);
        driving = 0;
      }
    }
    if(driving == 0) {
      talon1.setSelectedSensorPosition(0);
    }
    */
    System.out.println("Position: " + talon1.getSelectedSensorPosition());
    System.out.println("driving? " + driving);
    System.out.println("Button A pressed? " + xbox.getRawButton(RobotMap.buttonA));
    //drive_talon1.tankDrive(1,1);
    
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new Joystick_Drive());
  }
}
