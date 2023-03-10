/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ColorCommand;

/**
 * Add your docs here.
 */
public class ColorSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.za
  I2C.Port name;
  ColorSensorV3 sensor;
  public ColorSubsystem() {
    name = I2C.Port.kOnboard;
    sensor = new ColorSensorV3(name);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new ColorCommand());
  }

  public String getColor() {
    int red = sensor.getRed();
    int blue = sensor.getBlue();
    int green = sensor.getGreen();
    SmartDashboard.putNumber("vaseline pomegranate-mango red", red);
    SmartDashboard.putNumber("leslie blue", blue);
    SmartDashboard.putNumber("ser-green-evna", green); 
    return null;
  }
}
