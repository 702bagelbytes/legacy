/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.AutonomousGroup;
import frc.robot.commands.DriveForward;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  WPI_TalonSRX talonfl;
  WPI_TalonSRX talonfr;

  CANSparkMax sparkml;
  CANSparkMax sparkmr;
  CANSparkMax sparkbl;
  CANSparkMax sparkbr;

  DifferentialDrive highDrive;
  DifferentialDrive midDrive;
  DifferentialDrive lowDrive;

  public DriveSubsystem() {
    talonfl = new WPI_TalonSRX(RobotMap.talona);
    talonfr = new WPI_TalonSRX(RobotMap.talonb);

    sparkml = new CANSparkMax(RobotMap.spark2, MotorType.kBrushed);
    sparkmr = new CANSparkMax(RobotMap.spark4, MotorType.kBrushed);
    sparkbl = new CANSparkMax(RobotMap.spark3, MotorType.kBrushed);
    sparkbr = new CANSparkMax(RobotMap.spark1, MotorType.kBrushed);

    highDrive = new DifferentialDrive(talonfl, talonfr);
    midDrive = new DifferentialDrive(sparkml, sparkmr);
    lowDrive = new DifferentialDrive(sparkbl, sparkbr);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    //setDefaultCommand(new AutonomousGroup());
  }
  public void driveforward(double speed){
    highDrive.tankDrive(speed, speed);
    midDrive.tankDrive(-1*speed, -1*speed);
    lowDrive.tankDrive(-1*speed, -1*speed);
  }

}
