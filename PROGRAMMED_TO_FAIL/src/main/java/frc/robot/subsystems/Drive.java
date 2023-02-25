/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.DriveCommand;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * Add your docs here.
 */
public class Drive extends Subsystem {
  CANSparkMax sparkFrontRight;
  CANSparkMax sparkMidLeft;
  CANSparkMax sparkMidRight;
  CANSparkMax sparkFrontLeft;
  WPI_TalonSRX talonBackRight;
  WPI_TalonSRX talonBackLeft;
  DifferentialDrive Drive1;
  DifferentialDrive Drive2;
  DifferentialDrive Drive3;

  /**
   * Creates a new DriveSubsystem.
   */
  public Drive() {

    sparkFrontRight = new CANSparkMax(RobotMap.talonFR, MotorType.kBrushed);
    sparkFrontLeft = new CANSparkMax(RobotMap.talonFL, MotorType.kBrushed);
    sparkMidRight = new CANSparkMax(RobotMap.talonMR, MotorType.kBrushed);
    sparkMidLeft = new CANSparkMax(RobotMap.talonML, MotorType.kBrushed);

    talonBackLeft = new WPI_TalonSRX(RobotMap.talonBL);
    talonBackRight = new WPI_TalonSRX(RobotMap.talonBR);

    Drive1 = new DifferentialDrive(sparkFrontLeft, sparkFrontRight);
    Drive2 = new DifferentialDrive(sparkMidLeft, sparkMidRight);
    Drive3 = new DifferentialDrive(talonBackLeft, talonBackRight);
  }

  public void drive(Joystick a){  
    Drive1.tankDrive(a.getRawAxis(RobotMap.lsYA), a.getRawAxis(RobotMap.lsYA));
    Drive2.tankDrive(a.getRawAxis(RobotMap.lsYA), a.getRawAxis(RobotMap.lsYA));
    Drive3.tankDrive(a.getRawAxis(RobotMap.lsYA), a.getRawAxis(RobotMap.lsYA));
  }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveCommand());
  }
}
