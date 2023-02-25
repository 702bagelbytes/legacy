/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.Elevator_Command;
import frc.robot.commands.Joystick_Drive;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class ElevatorSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
WPI_TalonSRX elevatorMotor;
WPI_TalonSRX elevatorMotorII;
DifferentialDrive elevator;
public ElevatorSubsystem() {
  elevatorMotor = new WPI_TalonSRX(RobotMap.talonC);
  elevatorMotorII = new WPI_TalonSRX(RobotMap.talonC);
  elevator = new DifferentialDrive(elevatorMotor, elevatorMotorII);
}
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new Elevator_Command());
  }
  public void drive(Joystick a)
  {
  
    if (a.getRawAxis(RobotMap.triggerLeft) > 0.01){
      elevator.tankDrive((a.getRawAxis(RobotMap.triggerLeft)) , 0);
    }
    if (a.getRawAxis(RobotMap.triggerRight) > 0.01){
      elevator.tankDrive((a.getRawAxis(RobotMap.triggerRight)) , 0);
    }
  //   double axis = (a.getRawAxis(RobotMap.triggerLeft)) > 0.01 ? (1*a.getRawAxis(RobotMap.triggerLeft)) : 0;
  //elevator.tankDrive(1*a.getRawAxis(RobotMap.triggerLeft), (-1*a.getRawAxis(RobotMap.triggerRight)));
  // elevator.tankDrive(-1*a.getRawAxis(RobotMap.triggerRight), (-1*a.getRawAxis(RobotMap.triggerRight)));
  }


 /*
    Drive_Top.tankDrive(-1*a.getRawAxis(RobotMap.lsYA), -1*a.getRawAxis(RobotMap.rsYA));
    Drive_Mid.tankDrive(-1*a.getRawAxis(RobotMap.lsYA), -1*a.getRawAxis(RobotMap.rsYA));
    Drive_Bottom.tankDrive(-1*a.getRawAxis(RobotMap.lsYA), -1*a.getRawAxis(RobotMap.rsYA));
    */
  
}
