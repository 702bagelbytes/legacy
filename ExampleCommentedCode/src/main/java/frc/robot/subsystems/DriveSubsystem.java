/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/************************************************************************************
 * IMPORTANT THINGS TO IMPORT:
 * - RobotMap
 * - its command
 * - Joystick
 * OTHER OPTIONAL PARTS LIKE:
 * - talonSRX
 * - CanSparkMax
 * - mechanumDrive or DifferentialDrive
 * - encoders
 *************************************************************************************/
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;
import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;



/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  /*****************************************************************************************************
   * create the objects necessary like the differential drive and each talon
   *****************************************************************************************************/
  // one talon for each  motor
  WPI_TalonSRX talonFL;
  WPI_TalonSRX talonFR;
  WPI_TalonSRX talonML;
  WPI_TalonSRX talonMR;
  WPI_TalonSRX talonBL;
  WPI_TalonSRX talonBR;

  // one drive for each left & right motor.
  DifferentialDrive Drive_Top;
  DifferentialDrive Drive_Mid;
  DifferentialDrive Drive_Bottom;


  public DriveSubsystem() {
    /****************************************************************************************************
     * in the constructor, initialize the talons and differential/mechanum drives and give it the values
     ****************************************************************************************************/
    
    talonFL = new WPI_TalonSRX(RobotMap.talonFL);
    talonFR = new WPI_TalonSRX(RobotMap.talonFL);
    talonML = new WPI_TalonSRX(RobotMap.talonFL);
    talonMR = new WPI_TalonSRX(RobotMap.talonFL);
    talonBL = new WPI_TalonSRX(RobotMap.talonFL);
    talonBR = new WPI_TalonSRX(RobotMap.talonFL);
    Drive_Top = new DifferentialDrive(talonFL, talonFR);
    Drive_Mid = new DifferentialDrive(talonML, talonMR);
    Drive_Bottom = new DifferentialDrive(talonBL, talonBR);
    

  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    /*************************************************************************************************
     * SET ITS COMMAND USING setDefaultCommand(new MySpecialCommand());
     **************************************************************************************************/
    setDefaultCommand(new DriveCommand());
    
  }

  /****************************************************************************************************
   * Make its methods and functions so that it does something
   * public void name(parameters) {
   *    everything else
   * }
   * parameters are usually Joystick a
   ****************************************************************************************************/
  public void Drive(Joystick a) {


    /**************************************************************************************************
     * make the talons move using differentialdriveName.tankDrive(left speed, right speed);
     * if mecanum, change it to .mecanumDrive(parameters);
     ***************************************************************************************************/
    //tank drive code
    Drive_Top.tankDrive(a.getRawAxis(RobotMap.lsYA), a.getRawAxis(RobotMap.rsYA));
    Drive_Mid.tankDrive(a.getRawAxis(RobotMap.lsYA), a.getRawAxis(RobotMap.rsYA));
    Drive_Bottom.tankDrive(a.getRawAxis(RobotMap.lsYA), a.getRawAxis(RobotMap.rsYA));
    // arcade drive code
    /*
    Drive_Top.arcadeDrive(a.getRawAxis(RobotMap.lsYA), a.getRawAxis(RobotMap.lsXA));
    Drive_Mid.arcadeDrive(a.getRawAxis(RobotMap.lsYA), a.getRawAxis(RobotMap.lsXA));
    Drive_Bottom.arcadeDrive(a.getRawAxis(RobotMap.lsYA), a.getRawAxis(RobotMap.lsXA));
    */
  }
}
