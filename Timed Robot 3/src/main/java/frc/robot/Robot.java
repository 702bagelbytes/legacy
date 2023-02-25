/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class Robot extends TimedRobot {
  private WPI_TalonFX Falcon = new WPI_TalonFX(5);
  private double startTime;
  private Joystick joy1 = new Joystick(0);
  public final int lsYA = 1;
  public final int lsXA = 0;
  public final int rsYA = 5;
  public final int rsXA = 4;

  @Override
  public void robotInit() {

  }

  @Override
  public void autonomousInit() {
    startTime = Timer.getFPGATimestamp();
  }

  @Override
  public void autonomousPeriodic() {
    double time = Timer.getFPGATimestamp();
    if (time - startTime < 3){
      Falcon.set(0.6);
    } else {
      Falcon.set(0);
    }
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    double speed = joy1.getRawAxis(lsYA);
    Falcon.set(speed);
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
