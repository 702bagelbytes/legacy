/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.DriveCommand;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax.IdleMode;


import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;


/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  CANSparkMax SparkA; // left mid
  CANSparkMax SparkB; // left back
  CANSparkMax SparkC; // right mid
  CANSparkMax SparkD; // right back
  WPI_TalonSRX TalonA; // right front
  WPI_TalonSRX TalonB; // left front

  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
  Color detectedColor;
  double IR;

  //tank drive
  /*
  DifferentialDrive leftDrive;
  DifferentialDrive rightDrive;
  */
    //arcade drive
  
  DifferentialDrive frontDrive;
  DifferentialDrive midDrive;
  DifferentialDrive backDrive;
  
  double leftPos;
  double rightPos;

  public DriveSubsystem(){
    //Declaring Sparks
    SparkA = new CANSparkMax (RobotMap.SparkA, MotorType.kBrushed); // left mid
    SparkB = new CANSparkMax (RobotMap.SparkB, MotorType.kBrushed); // left back
    SparkC = new CANSparkMax (RobotMap.SparkC, MotorType.kBrushed); // right mid
    SparkD = new CANSparkMax (RobotMap.SparkD, MotorType.kBrushed); // right back
    //Declaring Talons
    TalonA = new WPI_TalonSRX(RobotMap.TalonA);
    TalonB = new WPI_TalonSRX(RobotMap.TalonB);
    
    leftPos = 0;
    rightPos = 0;
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
    
    frontDrive = new DifferentialDrive(TalonA, TalonB);
    midDrive = new DifferentialDrive(SparkA , SparkC);
    backDrive = new DifferentialDrive(SparkB, SparkD);
    TalonB.setInverted(true);




  }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //setDefaultCommand(new DriveCommand());
  }

  public void drive(Joystick a){
    /**
     * The method GetColor() returns a normalized color value from the sensor and can be
     * useful if outputting the color to an RGB LED or similar. To
     * read the raw color, use GetRawColor().
     * 
     * The color sensor works best when within a few inches from an object in
     * well lit conditions (the built in LED is a big help here!). The farther
     * an object is the more light from the surroundings will bleed into the 
     * measurements and make it difficult to accurately determine its color.
     */


    /**
     * Open Smart Dashboard or Shuffleboard to see the color detected by the 
     * sensor.
     */
    detectedColor = m_colorSensor.getColor();
    IR = m_colorSensor.getIR();
    
    SmartDashboard.putNumber("Red", detectedColor.getColor.red);
    SmartDashboard.putNumber("Green",detectedColor.getColor.green);
    
    SmartDashboard.putNumber("Blue", detectedColor.getColor.blue);
    SmartDashboard.putNumber("IR", IR);
        /**
     * In addition to RGB IR values, the color sensor can also return an 
     * infrared proximity value. The chip contains an IR led which will emit
     * IR pulses and measure the intensity of the return. When an object is 
     * close the value of the proximity will be large (max 2047 with default
     * settings) and will approach zero when the object is far away.
     * 
     * Proximity can be used to roughly approximate the distance of an object
     * or provide a threshold for when an object is close enough to provide
     * accurate color values.
     */
    int proximity = m_colorSensor.getProximity();

    SmartDashboard.putNumber("Proximity", proximity);




    if(a.getRawAxis(RobotMap.triggerLeft)>0.1)
    {
      if(a.getRawAxis(RobotMap.triggerRight)>0.1)
      {
          frontDrive.tankDrive(a.getRawAxis(RobotMap.lsYA), a.getRawAxis(RobotMap.rsYA));
          midDrive.tankDrive(a.getRawAxis(RobotMap.lsYA), a.getRawAxis(RobotMap.rsYA));
          backDrive.tankDrive(a.getRawAxis(RobotMap.lsYA), a.getRawAxis(RobotMap.rsYA));
      } else{
        frontDrive.tankDrive(0.5*a.getRawAxis(RobotMap.lsYA), 0.5*a.getRawAxis(RobotMap.rsYA));
        midDrive.tankDrive(0.5*a.getRawAxis(RobotMap.lsYA), 0.5*a.getRawAxis(RobotMap.rsYA));
        backDrive.tankDrive(0.5*a.getRawAxis(RobotMap.lsYA), 0.5*a.getRawAxis(RobotMap.rsYA));

      }
      
    } else {

      if(a.getRawAxis(RobotMap.triggerRight)>0.1)
      {
      frontDrive.arcadeDrive(a.getRawAxis(RobotMap.lsYA), -1*a.getRawAxis(RobotMap.rsXA));
      midDrive.arcadeDrive(a.getRawAxis(RobotMap.lsYA), -1*a.getRawAxis(RobotMap.rsXA));
      backDrive.arcadeDrive(a.getRawAxis(RobotMap.lsYA), -1*a.getRawAxis(RobotMap.rsXA));
    } else {
      frontDrive.arcadeDrive(0.5*a.getRawAxis(RobotMap.lsYA), -0.5*a.getRawAxis(RobotMap.rsXA));
      midDrive.arcadeDrive(0.5*a.getRawAxis(RobotMap.lsYA), -0.5*a.getRawAxis(RobotMap.rsXA));
      backDrive.arcadeDrive(0.5*a.getRawAxis(RobotMap.lsYA), -0.5*a.getRawAxis(RobotMap.rsXA));
    }
    }
  }
  public void driveForward(double speed) {
    frontDrive.tankDrive(-1*speed, -1*speed);
    midDrive.tankDrive(-1*speed,-1*speed);
    backDrive.tankDrive(-1*speed, -1*speed);
    leftPos+= speed;
    rightPos+= speed;

  }
  public void driveStop() {
    frontDrive.tankDrive(0, 0);
    midDrive.tankDrive(0, 0);
    backDrive.tankDrive(0, 0);

  }
  public void resetPos() {
    leftPos = 0;
    rightPos = 0;
  }
  public double getLeftPos() {
    return leftPos;
  }
  public double getRightPos() {
    return rightPos;
  }
  public void driveTurn(int direction, double speed) {
    // if direction is -1. go left, if direction is 1 go right
    frontDrive.tankDrive(-1*direction*speed, direction*speed);
    midDrive.tankDrive(direction*speed, direction*speed);
    backDrive.tankDrive(direction*speed, -1*direction*speed);
    leftPos+= direction*speed;
    rightPos+= -1*direction*speed;
  }
}
