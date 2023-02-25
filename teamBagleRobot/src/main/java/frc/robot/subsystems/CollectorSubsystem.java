/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.RobotMap;
import frc.robot.commands.CollectorCommand;
import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
/**
 * Add your docs here.
 */
public class CollectorSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  WPI_TalonSRX talonCollector;
  DifferentialDrive driveCollector;
  public CollectorSubsystem() {
    talonCollector = new WPI_TalonSRX(0);
    driveCollector = new DifferentialDrive(talonCollector, talonCollector);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new CollectorCommand());
  }

  public void Drive(Joystick a) {
    driveCollector.tankDrive(a.getRawAxis(RobotMap.triggerRight) - a.getRawAxis(RobotMap.triggerLeft), a.getRawAxis(RobotMap.triggerRight) - a.getRawAxis(RobotMap.triggerLeft));
  }
}
