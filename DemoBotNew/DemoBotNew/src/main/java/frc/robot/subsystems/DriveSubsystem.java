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


/**\
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  CANSparkMax sparkFR;
  CANSparkMax sparkMR;
  CANSparkMax sparkFL;
  CANSparkMax sparkBR;
  WPI_talonSRX talonML;
  WPI_talonSRX talonBL;
  DifferentialDrive lDrive;
  

  public DriveSubsystem() {
    talonML = new WPI_talonSRX(0);
    talonBL = new WPI_talonSRX(1);
    lDrive = new DifferentialDrive(talonML, talonBL);

    sparkFL = new CANSparkMax(2, MotorType.kBrushed);

    sparkFR = new CANSparkMax(1, MotorType.kBrushed);
    sparkMR = new CANSparkMax(4,MotorType.kBrushed);
    sparkBR = new CANSparkMax(3,MotorType.kBrushed);  
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveCommand());

  }
  public void drive(Joystick a){  
    lDrive.tankDrive(a.getRawAxis(RobotMap.lsYA), a.getRawAxis(RobotMap.lsYA));
    
    sparkFL.set(a.getRawAxis(RobotMap.lsYA));

    sparkMR.set(a.getRawAxis(RobotMap.rsYA));
    sparkFR.set(a.getRawAxis(RobotMap.rsYA));
    sparkBR.set(a.getRawAxis(RobotMap.rsYA));




    
  }
}
