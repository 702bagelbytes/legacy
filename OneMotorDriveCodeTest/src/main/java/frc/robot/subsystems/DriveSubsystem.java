/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;

public class DriveSubsystem extends Subsystem {
  WPI_TalonSRX talon;
  double speed;

  public DriveSubsystem() {
    talon = new WPI_TalonSRX(24);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveCommand());
  }

  public void drive(Joystick a) {
    talon.set(a.getRawAxis(RobotMap.lsYA));
  } 

  public void resetSoftDrive() {
    speed = 0;
  }

  public void softDrive(Joystick a) {
    if (a.getRawAxis(RobotMap.lsYA) > 0.1) {
      speed += 0.01;
      if(speed > 0.905) {
        speed = 0.905;
      }
    }
    if (a.getRawAxis(RobotMap.lsYA) < 0.1) {
      speed -= 0.01;
      if(speed < 0) {
        speed = 0;
      }
    }
    talon.set(speed); //need to put this outside if statement b/c if the statement is false, the talon's speed will not be set 
  }
}
