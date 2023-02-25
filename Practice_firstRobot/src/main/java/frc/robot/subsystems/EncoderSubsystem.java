/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrame;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.EncoderCommand;


/**
 * An example subsystem. You can replace me with your own Subsystem.
 */
public class EncoderSubsystem extends Subsystem {
  DifferentialDrive EncoderDrive;
  WPI_TalonSRX talon1;
  WPI_TalonSRX talon2;
  public EncoderSubsystem(){
    talon1 = new WPI_TalonSRX(RobotMap.talonD);
    talon2 = new WPI_TalonSRX(100);
    EncoderDrive = new DifferentialDrive(talon1, talon2);
    talon1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
    talon1.setStatusFramePeriod(StatusFrame.Status_2_Feedback0, 10);
    talon1.setSelectedSensorPosition(0);
  }

  // Declaring int
  int i = 0;
  public void EncoderMove(Joystick a) {
    //Switch on if statement
    if (a.getRawButton(RobotMap.button1)){
      i = 1;
      talon1.setSelectedSensorPosition(0);
    }
    //Drive
   
    //switch off
    if (talon1.getSelectedSensorPosition() >= 3800 || talon1.getSelectedSensorPosition() <= -3800){
      i = 0;
    }
    EncoderDrive.tankDrive(-0.35*i, 0);
  } //end public
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new EncoderCommand());
  }
}
