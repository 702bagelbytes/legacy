/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ExampleCommand;
/**********************************************************************
 * IMPORT each subsystem
 **********************************************************************/
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;



public class Robot extends TimedRobot {
  public static ExampleSubsystem m_subsystem = new ExampleSubsystem();
  public static OI m_oi;
  /********************************************************************
   * Call all the subsystems here.
   * how to call a subystem: public static <subsystem> <name>;
   * example: public static ExampleSubsystem mySubsystem;
   * Also create the dashboard
   * -> public SmartDashboard dash;
   ********************************************************************/
  public SmartDashboard dash;
  public static DriveSubsystem drive_Subsystem;

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /*******************************************************************
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   *******************************************************************/
  @Override
  public void robotInit() {
    // IMPORTANT: MAKE OI!!!! m_oi = new OI();
    m_oi = new OI();
    m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    SmartDashboard.putData("Auto mode", m_chooser);
    /*******************************************************************
     * Make each subsystem objects
     * how to make each subsytem object: <object name> = new <subsytem>();
     * ex: mySubsystem = new ExampleSystem();
     *******************************************************************/
    drive_Subsystem = new DriveSubsystem();

    //IMPORTANT: CALL OI init()!!!!! m_oi.init();
    m_oi.init();
  }

  /**********************************************************************
   * robotPeriodic is called every frame regardless of if it's autonomous or manual
   **********************************************************************/
  @Override
  public void robotPeriodic() {
  }

  /****************************************************************
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   *********************************************************************/
  @Override
  public void disabledInit() {
  }
  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * runs once when auto first starts
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  /**
   * This function is called every frame during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  // runs once when teleop starts
  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   * useful for putting code that isn't specific to any subsystem, 
   * also useful for putting overall code that manages all subsystems
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    //SmartDashboard.putNumber("Encoder position", ClawPID_Subsystem.sparkEncoder.getPosition());
    SmartDashboard.putNumber("Goal", 10*Robot.m_oi.getJoystick().getRawAxis(RobotMap.lsYA));
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
