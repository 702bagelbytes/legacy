/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.BallCollectorCommand;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * Add your docs here.
 */
public class BallCollectorSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  WPI_TalonSRX Collector;
  DifferentialDrive CollectorDrive;
  public BallCollectorSubsystem(){
    Collector = new WPI_TalonSRX(RobotMap.collectortalon);
    CollectorDrive = new DifferentialDrive(Collector, Collector);
  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new BallCollectorCommand());
  }
  
  public void drive (Joystick a){
    CollectorDrive.tankDrive(1*a.getRawAxis(RobotMap.triggerLeft) -a.getRawAxis(RobotMap.triggerRight), (1*a.getRawAxis(RobotMap.triggerLeft)-a.getRawAxis(RobotMap.triggerRight)));
  }
}
