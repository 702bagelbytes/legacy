/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.DriveCommand;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.drive.MecanumDrive;


/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  WPI_TalonSRX talonFL;
  WPI_TalonSRX talonFR;
  WPI_TalonSRX talonRL;
  WPI_TalonSRX talonRR;

  MecanumDrive driveA;
  public DriveSubsystem() {
    talonFL = new WPI_TalonSRX(RobotMap.talonFL);
    talonFR = new WPI_TalonSRX(RobotMap.talonFR);
    talonRL = new WPI_TalonSRX(RobotMap.talonBL);
    talonRR = new WPI_TalonSRX(RobotMap.talonBR);
  
    driveA = new MecanumDrive(talonFL, talonFR, talonRL, talonRR);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveCommand());
  }
  public void Drive(Joystick a) {
    driveA.driveCartesian(a.getRawAxis(RobotMap.lsYA), a.getRawAxis(RobotMap.lsXA), a.getRawAxis(RobotMap.rsXA));
  }
}
