// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends CommandBase {
  /** Creates a new DriveCommand. */

  private final DriveSubsystem drive;
  private final double speed;
  Timer timer;


  public DriveCommand(DriveSubsystem m_drive, double m_speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    drive = m_drive;
    speed = m_speed;
    timer = new Timer();
    addRequirements(drive);

  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
    while(timer.get() < 5){
      drive.setSpeed(speed);
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //drive.setRight(rightspeed);
    //drive.setLeft(leftspeed);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.setSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}