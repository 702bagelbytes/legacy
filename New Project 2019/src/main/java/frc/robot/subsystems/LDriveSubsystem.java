/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.LDriveCommand;

/**
 * Add your docs here.
 */

public class LDriveSubsystem extends Subsystem {
  //CANSparkMax SparkAA;
  //CANSparkMax SparkBA;
  public LDriveSubsystem()
  {
   // TalonLeft = new WPI_TalonSRX(RobotMap.talon1);
     //SparkAA = new CANSparkMax(3, MotorType.kBrushless);
     //SparkBA = new CANSparkMax(4, MotorType.kBrushless);
  }

  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new LDriveCommand());

  }
  public void drive(Joystick a){
    jongDriveFront.tankDrive(1*a.getRawAxis(RobotMap.lsYA), 1*a.getRawAxis(RobotMap.lsXA));
    LeftDrive.tankDrive(1*a.getRawAxis(RobotMap.lsYA), 1*a.getRawAxis(RobotMap.lsXA));
    SparkAA.set(0.1);
    SparkBA.set(0.1);

  }
}
