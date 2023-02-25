/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// color
import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.I2C;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;

public class ColorMechanismSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  WPI_TalonSRX TalonColor;
  // create the color sensor objects
  private I2C.Port i2cPort;
  private ColorSensorV3 m_colorSensor;
  // create variables for the color
  Color detectedColor;
  double IR;

  public ColorMechanismSubsystem() {
    TalonColor = new WPI_TalonSRX(RobotMap.TalonColor);
    i2cPort = I2C.Port.kOnboard;
    m_colorSensor = new ColorSensorV3(i2cPort);
    TalonColor.setInverted(true);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public void drive(double speed) {
    TalonColor.set(speed);
  }
  
  public void stop() {
    TalonColor.set(0);
  }

  double redValue;
  double blueValue;
  double greenValue;
  String strongestColor;
  public String getSensorColor() {
    // activate sensor
    detectedColor = m_colorSensor.getColor();
    // extract colors and assign to variables
    redValue = detectedColor.red;
    blueValue = detectedColor.blue;
    greenValue = detectedColor.green;
    // get strongest color
    strongestColor = 
      redValue > greenValue && redValue > blueValue ? "RED" : // IF RED GREATEST
      blueValue > redValue && blueValue > greenValue ? "BLUE" : // IF BLUE GREATEST
      greenValue > redValue && greenValue > blueValue ? "GREEN" : // IF GREEN GREATEST
      "NONE"; // ELSE

    if(strongestColor == "RED") {
      return "RED";
    } else if(strongestColor == "GREEN" ) { // GREEN STRONGEST COULD MEAN ANY OF THE 4 COLORS
      if(redValue > greenValue/2 && greenValue > 0.48 && blueValue < 0.22) {
        if(greenValue < 0.5) {
          return "YELLOW";
        }
        return "YELLOW";
      } else if(redValue < 0.265 && greenValue > 0.49){  
        return "GREEN";
      } else if(blueValue < 0.21 && blueValue > 0.15 && redValue > 0.33 && greenValue < 0.46) {
        return "RED";
      } else if (redValue < 0.25 && greenValue < 0.475 && greenValue > 0.4 && blueValue > 0.25){
        return "BLUE";
      } else {
        return "NONE";  
      }      
    } else if(strongestColor == "BLUE") {
        return "BLUE";
    } 
    return "NONE";
  }

}
