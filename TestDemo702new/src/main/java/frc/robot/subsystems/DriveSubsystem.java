/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.DriveCommandTeleop;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  CANSparkMax sparkBL;
  CANSparkMax sparkBR;
  CANSparkMax sparkML;
  CANSparkMax sparkMR;
  WPI_TalonSRX talonFL;
  WPI_TalonSRX talonFR;
  DifferentialDrive frontDrive;
  DifferentialDrive midDrive;
  DifferentialDrive backDrive;
  public DriveSubsystem(){
    sparkBL = new CANSparkMax(1, MotorType.kBrushed);
    sparkBR = new CANSparkMax(2, MotorType.kBrushed);
    sparkML = new CANSparkMax(3, MotorType.kBrushed);
    sparkMR = new CANSparkMax(4, MotorType.kBrushed);
    talonFL = new WPI_TalonSRX(21);
    talonFR = new WPI_TalonSRX(29);
    frontDrive = new DifferentialDrive(talonFL, talonFR);
    midDrive = new DifferentialDrive(sparkML, sparkMR);
    backDrive = new DifferentialDrive(sparkBL, sparkBR);
  }

  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveCommandTeleop());
  }

  public void teleop(Joystick joy){
    // dead zones
    if (Math.abs(joy.getRawAxis(RobotMap.lsXA)) < 0.1 && Math.abs(joy.getRawAxis(RobotMap.lsYA)) < 0.1) {
      frontDrive.tankDrive(0, 0);
      midDrive.tankDrive(0, 0);
      backDrive.tankDrive(0, 0);
    }
    else{
    frontDrive.tankDrive(joy.getRawAxis(RobotMap.lsYA), joy.getRawAxis(RobotMap.rsYA));
    midDrive.tankDrive(joy.getRawAxis(RobotMap.lsYA), joy.getRawAxis(RobotMap.rsYA));
    backDrive.tankDrive(joy.getRawAxis(RobotMap.lsYA), joy.getRawAxis(RobotMap.rsYA));
    }
  }
  public void forwarddrive(double speed){
    frontDrive.tankDrive(speed, speed);
    midDrive.tankDrive(speed, speed);
    backDrive.tankDrive(speed, speed);
  }
  public void stopdrive(){
    frontDrive.tankDrive(0, 0);
    midDrive.tankDrive(0, 0);
    backDrive.tankDrive(0, 0);
  }
}
