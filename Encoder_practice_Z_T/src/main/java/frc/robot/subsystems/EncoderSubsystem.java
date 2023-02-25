/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;;
/**
 * Add your docs here.
 */
public class EncoderSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  WPI_TalonFX Falcon;
  public EncoderSubsystem(){
    Falcon = new WPI_TalonFX(3);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    

  }
  public void drive(double speed){
    Falcon.set(speed);
  }
  public void setEncoderPosition(int number){
    Falcon.setSelectedSensorPosition(number);
    
  }
  public int getEncoderPosition(){
   return Falcon.getSelectedSensorPosition();
    
  }
}
