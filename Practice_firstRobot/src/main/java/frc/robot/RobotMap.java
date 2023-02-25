/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
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
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;
public static final int leftStickY_Axis = 1;
public static final int leftStickX_Axis = 0;
public static final int rightStickY_Axis = 5;
public static final int rightStickX_Axis = 4;
public static final int triggerRight = 3;
public static final int triggerLeft = 2;

public static final int rightBumper = 5;
public static final int leftBumper = 6;

public static final int buttonA = 1;
public static final int buttonB = 2;
public static final int buttonX = 3;
public static final int buttonY = 4;

public static final int buttonLeft = 5;
public static final int buttonRight = 6;

public static final int talonFL = 33;
public static final int SparkA = 34;
//public static final int talonFL = 20;
public static final int talonFR = 24;
public static final int talonML = 22;
public static final int talonMR = 27;
public static final int talonBL = 23;
public static final int talonBR = 21;
public static final int talonCollector = 30;
public static final int talonElevator = 32;
  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
