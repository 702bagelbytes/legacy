// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  enum Talons {
    FRONT_RIGHT(new WPI_TalonSRX(29)),
    BACK_LEFT(new WPI_TalonSRX(30)),
    FRONT_LEFT(new WPI_TalonSRX(21)),
    BACK_RIGHT(new WPI_TalonSRX(27));
    WPI_TalonSRX talon;

    Talons(WPI_TalonSRX talon) {
      this.talon = talon;
    } 
  }

  final static MecanumDrive drive;
  final static XboxController controller;

  static {
    drive = new MecanumDrive(Talons.FRONT_RIGHT.talon, Talons.FRONT_LEFT.talon, Talons.BACK_RIGHT.talon, Talons.BACK_LEFT.talon);
    controller = new XboxController(0);
  }

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    Talons.BACK_RIGHT.talon.setInverted(true);
    Talons.FRONT_RIGHT.talon.setInverted(true);
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    drive.driveCartesian(controller.getLeftY(), controller.getLeftX(), controller.getRightX());
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
