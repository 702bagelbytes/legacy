/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.Collector_Command;
import frc.robot.commands.Joystick_Drive;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;


/**
 * Add your docs here.
 */
public class collector_Subsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  WPI_TalonSRX talonC;
  WPI_TalonSRX talonZ;
  double triggerRightOn;
  double triggerLeftOn;
  DifferentialDrive Drive_Collector;

  public collector_Subsystem(){
    talonC = new WPI_TalonSRX(RobotMap.talonC);
    talonZ = new WPI_TalonSRX(100);
    Drive_Collector = new DifferentialDrive(talonC, talonZ);
  }

  public void drive(Joystick a){
    triggerRightOn = 1*a.getRawAxis(RobotMap.triggerRight);
    triggerLeftOn = 1*a.getRawAxis(RobotMap.triggerLeft);
    Drive_Collector.tankDrive(triggerRightOn, triggerRightOn);
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new Collector_Command());
  }
}
