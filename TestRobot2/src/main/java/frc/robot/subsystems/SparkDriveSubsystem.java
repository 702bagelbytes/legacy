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
import frc.robot.commands.SparkDriveCommand;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class SparkDriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  CANSparkMax sparkFL;
  CANSparkMax sparkFR;
  CANSparkMax sparkBL;
  CANSparkMax sparkBR;
  //MecanumDrive drive = new MecanumDrive(sparkFL, sparkBL, sparkFR, sparkBR);
  public SparkDriveSubsystem() {
    /*
    sparkFL = new CANSparkMax(0, MotorType.kBrushless);
    sparkFR = new CANSparkMax(1, MotorType.kBrushless);
    sparkBL = new CANSparkMax(2, MotorType.kBrushless);
    sparkBR = new CANSparkMax(3, MotorType.kBrushless);
    */
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new SparkDriveCommand());
  }
  public void Drive(Joystick a) {
    /*
    sparkFL.set(a.getRawAxis(RobotMap.lsYA));
    sparkFR.set(a.getRawAxis(RobotMap.rsYA));
    sparkBL.set(a.getRawAxis(RobotMap.lsYA));
    sparkBR.set(a.getRawAxis(RobotMap.rsYA));
    */
  }
}
