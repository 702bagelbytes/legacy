/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.commands.DriveCommand;

/**
 * Add your docs here.
 */
public class Drive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  CANSparkMax sparkTL ;  //define sparks and import them
  CANSparkMax sparkTR ;
  DifferentialDrive topDrive; //define all differential drives and import them
  CANSparkMax sparkML ;
  CANSparkMax sparkMR ;
  DifferentialDrive midDrive;

  public Drive() {
    sparkTL = new CANSparkMax(RobotMap.SparkD, MotorType.kBrushed); //make new spark object
    sparkTR = new CANSparkMax(RobotMap.SparkB, MotorType.kBrushed);
    topDrive = new DifferentialDrive(sparkTL, sparkTR); //make new differential drive object
    sparkML = new CANSparkMax(RobotMap.SparkC, MotorType.kBrushed);
    sparkMR = new CANSparkMax(RobotMap.SparkA, MotorType.kBrushed);
    midDrive = new DifferentialDrive(sparkML, sparkMR);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveCommand()); //when not running other commands, will run the DriveCommand
  }
  public void actualDrive(Joystick a) {
    topDrive.tankDrive(a.getRawAxis(RobotMap.lsYA), a.getRawAxis(RobotMap.rsYA)); // doing tankDrive, which requires the axis which you get from RobotMap: lsYA, rsYA, etc
    midDrive.tankDrive(a.getRawAxis(RobotMap.lsYA), a.getRawAxis(RobotMap.rsYA));
  }
}
