/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  public static final int lsYA = 1; // left  stick y axis
  public static final int lsXA = 0; // left  stick x axis
  public static final int rsYA = 5; // right stick y axis
  public static final int rsXA = 4; // right stick x axis
  // controller bumper triggers
  public static final int triggerR = 3;
  public static final int triggerL = 2;
  // controller buttons
  public static final int buttonYellow = 4;
  public static final int buttonRed = 2;
  public static final int buttonBlue = 3;
  public static final int buttonGreen = 1;
  // controller button bumpers
  public static final int bumperL = 5;
  public static final int bumperR = 6;

  // Speed controller DRIVE 
  public static final int talonFL = 28;
  public static final int talonFR = 23;
  public static final int talonML = 20;
  public static final int talonMR = 24;
  public static final int talonBL = 22;
  public static final int talonBR = 27;

  // Speed controller INTAKE
  public static final int FalconArm = 2;
  public static final int talonIntake = 0;
  
  // Speed controller CONVEYOR
  public static final int talonConveyor = 7;

  // Speed controller SHOOTER
  public static final int falconShooter = 6;
  public static final int talonColor = 5;
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
