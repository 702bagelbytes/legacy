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

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
  public static final int lsYA = 1;
  public static final int lsXA = 0;
  public static final int rsYA = 5;
  public static final int rsXA = 4;

  public static final int triggerRight = 3;
  public static final int triggerLeft = 2;

  public static final int talonFL = 0;
  public static final int talonFR = 0;
  public static final int talonBL = 0;
  public static final int talonBR = 0;

  public static final int sparkElevator = 0;
  public static final int talonCollector = 0;
  public static final int sparkArm = 0;

  public static final int button1 = 1;
  public static final int button2 = 2;
  public static final int button3 = 8;
  public static final int button4 = 9;
}
