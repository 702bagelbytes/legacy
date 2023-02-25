/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import frc.robot.commands.RDriveCommand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import com.revrobotics.CANSparkMax;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Robot;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
/**
 * Add your docs here.
 */

public class RDriveSubsystem extends Subsystem {
  CANSparkMax SparkAB;
  //CANSparkMax SparkBB;
  public RDriveSubsystem()
  {
   // TalonLeft = new WPI_TalonSRX(RobotMap.talon1);
    SparkAB = new CANSparkMax(1, MotorType.kBrushless);
    //SparkBB = new CANSparkMax(2, MotorType.kBrushless);
  }

  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new RDriveCommand());

  }
  public void drive(Joystick a){
    //jongDriveFront.tankDrive(1*a.getRawAxis(RobotMap.lsYA), 1*a.getRawAxis(RobotMap.lsXA));
    //LeftDrive.tankDrive(1*a.getRawAxis(RobotMap.lsYA), 1*a.getRawAxis(RobotMap.lsXA));
    SparkAB.set(0.3);
    //SparkBB.set(0.1);

  }
}
