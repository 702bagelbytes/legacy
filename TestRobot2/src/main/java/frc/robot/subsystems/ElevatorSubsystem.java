/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.RobotMap;
//import frc.robot.commands.ElevatorCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class ElevatorSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  WPI_TalonSRX talonElevator;
  WPI_TalonSRX talonHolder;
  
  
  DifferentialDrive Drive_Elevator;
  public ElevatorSubsystem() {
/*
    talonElevator = new WPI_TalonSRX(RobotMap.talonElevator);
    talonHolder = new WPI_TalonSRX(100);

    Drive_Elevator = new DifferentialDrive(talonElevator, talonHolder);
*/
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    //setDefaultCommand(new ElevatorCommand());
  }
  public void Drive(Joystick a) {
    //Drive_Elevator.tankDrive(a.getRawAxis(RobotMap.triggerRight) - a.getRawAxis(RobotMap.triggerLeft), 0);

  }
}
