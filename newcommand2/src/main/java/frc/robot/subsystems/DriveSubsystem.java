/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.DriveCommand;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax.IdleMode;
/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  CANSparkMax SparkA;
  CANSparkMax SparkB;
  CANSparkMax SparkC;
  CANSparkMax SparkD;
  WPI_TalonSRX TalonA;
  WPI_TalonSRX TalonB;
  //tank drive
  /*
  DifferentialDrive leftDrive;
  DifferentialDrive rightDrive;
  */
    //arcade drive
  
  DifferentialDrive frontDrive;
  DifferentialDrive midDrive;
  DifferentialDrive backDrive;
  
  public DriveSubsystem(){
    //Declaring Sparks
    SparkA = new CANSparkMax (RobotMap.SparkA, MotorType.kBrushed);
    SparkB = new CANSparkMax (RobotMap.SparkB, MotorType.kBrushed);
    SparkC = new CANSparkMax (RobotMap.SparkC, MotorType.kBrushed);
    SparkD = new CANSparkMax (RobotMap.SparkD, MotorType.kBrushed);
    //Declaring Talons
    TalonA = new WPI_TalonSRX(RobotMap.TalonA);
    TalonB = new WPI_TalonSRX(RobotMap.TalonB);
    //tank drive
    //Declaring Drive
    /*
    leftDrive = new DifferentialDrive(TalonA, TalonA);
    rightDrive = new DifferentialDrive(TalonB, TalonB);
    SparkA.setIdleMode(IdleMode.kBrake);
    SparkB.setIdleMode(IdleMode.kBrake);
    SparkC.setIdleMode(IdleMode.kBrake);
    SparkD.setIdleMode(IdleMode.kBrake);
    */
    //arcade drive
    
    frontDrive = new DifferentialDrive(TalonB, TalonA);
    midDrive = new DifferentialDrive(SparkA , SparkC);
    backDrive = new DifferentialDrive(SparkB, SparkD);
    
  }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveCommand());
  }
  double speedmultiplyer = 0.75;
  double speedY = 0;
  double speedX = 0;
  double realSpeedY = 0;
  double realSpeedX = 0;
  public void drive(Joystick a){
    // arcade drive
    //
    
    realSpeedY = a.getRawAxis(RobotMap.lsYA);
    realSpeedX = -1*a.getRawAxis(RobotMap.rsXA);
    if(realSpeedY < 0.4) {
      realSpeedX = realSpeedX * -1;
    }
    speedY += (realSpeedY - speedY)/5;
    speedX += (realSpeedX - speedX)/5;
    System.out.println("speedY: " + speedY + "   speedX: " + speedX);


    if(a.getRawAxis(RobotMap.triggerRight) > 0.1) {    
      frontDrive.arcadeDrive(speedY, speedX);
      midDrive.arcadeDrive(speedY, -1*speedX);
      backDrive.arcadeDrive(speedY, -1*speedX);

    } else {
      frontDrive.arcadeDrive(speedmultiplyer*speedY, speedX);
      midDrive.arcadeDrive(speedmultiplyer*speedY, -1*speedX);
      backDrive.arcadeDrive(speedmultiplyer*speedY,-1*speedX);

    }
    //

    /*tank drive

    if(a.getRawAxis(RobotMap.triggerRight)>0.1){
      speedmultiplyer = 1;
    } else {
      speedmultiplyer = 0.5;
      

    }
    if(a.getRawAxis(RobotMap.lsYA) > 0.2 || a.getRawAxis(RobotMap.lsYA) < -0.2) {
      SparkA.set(speedmultiplyer*a.getRawAxis(RobotMap.lsYA));
      SparkB.set(speedmultiplyer*a.getRawAxis(RobotMap.lsYA));
      leftDrive.tankDrive(speedmultiplyer*a.getRawAxis(RobotMap.lsYA), speedmultiplyer*a.getRawAxis(RobotMap.lsYA));

    } else {
      SparkA.set(0);
      SparkB.set(0);
      leftDrive.tankDrive(0, 0);
    }
    if(a.getRawAxis(RobotMap.rsYA) > 0.2 || a.getRawAxis(RobotMap.rsYA) < -0.2) {
      SparkC.set(-1*speedmultiplyer*a.getRawAxis(RobotMap.rsYA));
      SparkD.set(-1*speedmultiplyer*a.getRawAxis(RobotMap.rsYA));
      rightDrive.tankDrive(-1*speedmultiplyer*a.getRawAxis(RobotMap.rsYA), -1*speedmultiplyer*a.getRawAxis(RobotMap.rsYA));
    } else {
      SparkC.set(0);
      SparkD.set(0);
      rightDrive.tankDrive(0, 0);
    }
    
    if(Math.abs(a.getRawAxis(RobotMap.lsYA)) < 0.1 && Math.abs(a.getRawAxis(RobotMap.rsYA)) < 0.1) {
      rightDrive.tankDrive(0,0);
      leftDrive.tankDrive(0, 0);
      SparkC.set(0);
      SparkD.set(0);
      SparkA.set(0);
      SparkB.set(0);
    }

*/
  }
}
