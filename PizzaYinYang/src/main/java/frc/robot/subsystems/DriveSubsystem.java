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
import edu.wpi.first.wpilibj.Joystick;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.commands.DriveCommand;
/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  CANSparkMax sparkTL ;
  CANSparkMax sparkTR ;
  DifferentialDrive topDrive; 
  CANSparkMax sparkML ;
  CANSparkMax sparkMR ;
  //2 is top right
  //4 is top left
  //1 is mid right
  //3 is mid left
  DifferentialDrive midDrive;
  public DriveSubsystem(){
    sparkTL = new CANSparkMax(RobotMap.SparkD, MotorType.kBrushed);
    sparkTR = new CANSparkMax(RobotMap.SparkB, MotorType.kBrushed);
    topDrive = new DifferentialDrive(sparkTL, sparkTR);
    sparkML = new CANSparkMax(RobotMap.SparkC, MotorType.kBrushed);
    sparkMR = new CANSparkMax(RobotMap.SparkA, MotorType.kBrushed);
    midDrive = new DifferentialDrive(sparkML, sparkMR);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

    setDefaultCommand(new DriveCommand());
  }
  
  public void Drive(Joystick a) {
    topDrive.tankDrive(a.getRawAxis( RobotMap.lsYA), a.getRawAxis( RobotMap.rsYA));
    midDrive.tankDrive(a.getRawAxis( RobotMap.lsYA), a.getRawAxis( RobotMap.rsYA));
  }
}
