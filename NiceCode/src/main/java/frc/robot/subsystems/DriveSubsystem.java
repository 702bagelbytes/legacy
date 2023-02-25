/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.commands.DriveCommand;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.RobotMap;



/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  WPI_TalonSRX FrontL;
  WPI_TalonSRX FrontR;
  WPI_TalonSRX BackL;
  WPI_TalonSRX BackR;
  MecanumDrive MDrive;
  
  public DriveSubsystem() {
    FrontL = new WPI_TalonSRX(RobotMap.FrontLeftTalon);
    FrontR = new WPI_TalonSRX(RobotMap.FrontRightTalon);
    BackL = new WPI_TalonSRX(RobotMap.BackLeftTalon);
    BackR = new WPI_TalonSRX(RobotMap.BackRightTalon);
    MDrive = new MecanumDrive(FrontL, BackL, FrontR, BackR);
  } 

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveCommand());
  }
  public void drive(Joystick a){
    //jongDriveFront.tankDrive(1*a.getRawAxis(RobotMap.lsYA), 1*a.getRawAxis(RobotMap.lsXA));
    MDrive.driveCartesian((1*a.getRawAxis(RobotMap.lsXA)) , (1*a.getRawAxis(RobotMap.lsYA)) ,(1*a.getRawAxis(RobotMap.rsXA)));
  }
}
