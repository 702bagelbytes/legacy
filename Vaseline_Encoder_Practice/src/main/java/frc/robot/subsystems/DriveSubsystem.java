/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.DriveCommand;
/**
 * Add your docs here.
 */

public class DriveSubsystem extends Subsystem {
  WPI_TalonFX shoulderShrug;
  int encoderPos;
  int phase;
  public DriveSubsystem() {
    shoulderShrug = new WPI_TalonFX(6);
    int encoderPos = 0;
    shoulderShrug.setSelectedSensorPosition(0);
    phase = 0;
    speed = 0;
  }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveCommand());
  }

  public void resetEncoderPosition() {
    shoulderShrug.setSelectedSensorPosition(0);
  }

  public void getEncoderPosition(){
    shoulderShrug.getSelectedSensorPosition();
  }

  public void setPhase() {
    phase = 0;
  }
  double speed;
  public void DriveForward(Joystick a) {
    /*
    encoderPos =  shoulderShrug.getSelectedSensorPosition();
    if(phase == 0) {
      shoulderShrug.set(0.1);
      if(encoderPos > 10000) {
        phase = 1;
      }
    }  
    else if(phase == 1) {
      shoulderShrug.set(0.2);
      if (encoderPos >= 100000) {
        phase = 2;
      }
    }
    else if (phase == 2) {
      shoulderShrug.set(-0.1);
      if (encoderPos <= 0) {
        phase = 3;
      }
    } else {
      shoulderShrug.set(0);
    }

    SmartDashboard.putNumber("Phase", phase);
    SmartDashboard.putNumber("Encoder Position", encoderPos);
*/
// 0.91 works 
    double maxSpeed = 0.90;
    double accelaration = 0.01;
    if(a.getRawAxis(RobotMap.lsYA) > 0.1) {
      speed += accelaration;
      if(speed > maxSpeed) {
        speed = maxSpeed;
      }
    } else {
      speed -= accelaration;
      if(speed < 0) {
        speed = 0;
      }
    }
    shoulderShrug.set(-1*speed);
  }
}
