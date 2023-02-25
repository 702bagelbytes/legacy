/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX; 
import com.revrobotics.CANSparkMax; 
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class drivebase extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  WPI_TalonSRX talonFL;
  WPI_TalonSRX talonFR;
  CANSparkMax sparkML;
  CANSparkMax sparkMR;
  CANSparkMax sparkBL;
  CANSparkMax sparkBR;
  public drivebase(){
    talonFL= new WPI_TalonSRX(RobotMap.talonFL);
    talonFR= new WPI_TalonSRX(RobotMap.talonFR);
    sparkML= new CANSparkMax(RobotMap.sparkML);
    sparkMR= new CANSparkMax(RobotMap.sparkMR);
    sparkBL= new CANSparkMax(RobotMap.sparkBL);
    sparkBR= new CANSparkMax(RobotMap.sparkBR);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
