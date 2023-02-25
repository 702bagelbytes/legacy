/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;
import frc.robot.commands.Collector_Command;
import frc.robot.commands.Elevator_Command;
import frc.robot.commands.Joystick_Drive;
import jdk.jshell.Diag;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Elevator_Subsystem extends Subsystem {
    WPI_TalonSRX elevatorMotor;
    WPI_TalonSRX elevatorMotor2;
    DifferentialDrive drive_Elevator;
    public Elevator_Subsystem (){
      super();
      elevatorMotor = new WPI_TalonSRX(RobotMap.talonElevator);
      elevatorMotor2 = new WPI_TalonSRX(0);
      drive_Elevator = new DifferentialDrive(elevatorMotor, elevatorMotor2);
    }//end constructor
    
  public void elevate(Joystick xbox) {
    if(xbox.getRawButton(RobotMap.leftBumper) == true) {
      drive_Elevator.tankDrive(0.5, 0.0);
    }//end if
    if(xbox.getRawButton(RobotMap.rightBumper) == true) {
      drive_Elevator.tankDrive(-0.5, 0.0);
    }//end if
    else{
      drive_Elevator.tankDrive(0.0, 0.0);
    }
  }//end collector
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new Elevator_Command());
  }
}
