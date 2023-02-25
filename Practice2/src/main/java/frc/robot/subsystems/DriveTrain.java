/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.JoystickTank;
import edu.wpi.first.wpilibj.Joystick;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public WPI_TalonSRX motorLeft;
  public WPI_TalonSRX motorRight;
  public CANSparkMax armSpark;
  public CANSparkMax centralSpark;
  public CANSparkMax spinnerSpark;
  public DifferentialDrive drive;

  public DriveTrain()
  {
    super();

    motorLeft = new WPI_TalonSRX(RobotMap.lTalon);
    motorRight = new WPI_TalonSRX(RobotMap.rTalon);
    armSpark = new CANSparkMax(0, MotorType.kBrushed);
    centralSpark = new CANSparkMax(0, MotorType.kBrushed);
    spinnerSpark = new CANSparkMax(0, MotorType.kBrushed);

    drive = new DifferentialDrive(motorLeft, motorRight);
    // driveTop = new DifferentialDrive(motorFL, motorFR);
    // driveTop = new DifferentialDrive(motorFL, motorFR);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new JoystickTank());
  }

  public void drive(Joystick xbox)
  {
    drive.tankDrive(xbox.getRawAxis(RobotMap.lsYA), xbox.getRawAxis(RobotMap.rsYA));
    armSpark.set(0);
    centralSpark.set(0);
    spinnerSpark.set(0);

  }
}
