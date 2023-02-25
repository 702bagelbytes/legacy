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
import frc.robot.commands.Collector_Command;
import frc.robot.commands.Joystick_Drive;
import jdk.jshell.Diag;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Collector_Subsystem extends Subsystem {
  //Declaring Collecter
  WPI_TalonSRX motorCollector;
  WPI_TalonSRX motorCollectorII;
  DifferentialDrive drive_collector;
  
  //Subsystem Command
  public Collector_Subsystem (){
    motorCollectorII = new WPI_TalonSRX (0);
    motorCollector = new WPI_TalonSRX (RobotMap.talonCollector);
    // Set the default command for a subsystem here.
    drive_collector = new DifferentialDrive(motorCollector, motorCollectorII);
  }
  public void collector (Joystick xbox){
    if (xbox.getRawAxis(RobotMap.triggerRight) > 0.01){
      drive_collector.tankDrive(1*xbox.getRawAxis(RobotMap.triggerRight),1*xbox.getRawAxis(RobotMap.triggerRight));
    }
    else if (xbox.getRawAxis(RobotMap.triggerLeft) > 0.01)
    {
      drive_collector.tankDrive(-1*xbox.getRawAxis(RobotMap.triggerLeft),-1*xbox.getRawAxis(RobotMap.triggerLeft));
    
    } else {
      drive_collector.tankDrive(0,0);
    }
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new Collector_Command());
  }
}
