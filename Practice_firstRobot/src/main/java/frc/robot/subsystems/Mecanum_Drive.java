/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;
import frc.robot.commands.Mecanum_Command;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 * Add your docs here.
 */
public class Mecanum_Drive extends Subsystem {
  WPI_TalonSRX FL;
  WPI_TalonSRX FR;
  WPI_TalonSRX BL;
  WPI_TalonSRX BR;
  MecanumDrive driver;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public Mecanum_Drive() {
    FL = new WPI_TalonSRX(RobotMap.talonFL);
    FR = new WPI_TalonSRX(RobotMap.talonFR);
    BL = new WPI_TalonSRX(RobotMap.talonBL);
    BR = new WPI_TalonSRX(RobotMap.talonBR);
    driver = new MecanumDrive(FL, BL, FR, BR);
  }//end constructor

  public void drive(Joystick xbox) {
      driver.driveCartesian(xbox.getRawAxis(RobotMap.leftStickY_Axis), xbox.getRawAxis(RobotMap.leftStickX_Axis), xbox.getRawAxis(RobotMap.rightStickX_Axis));
   
  }//end drive method
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new Mecanum_Command());

  }
}
