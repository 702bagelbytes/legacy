/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveForward extends Command {
  int driveLength;
  double driveSpeed;
  // default 40, 0.7
  public DriveForward(int length, double speed) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.drive);
    driveLength = length;
    driveSpeed = speed;
    Robot.drive.resetPos();

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.drive.resetPos();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.drive.driveForward(driveSpeed);
    System.out.println("DriveForward; Left: " + Robot.drive.getLeftPos() + " Right: " + Robot.drive.getRightPos());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(Robot.drive.getLeftPos()>driveLength || Robot.drive.getRightPos() > driveLength) {

      return true;
    }

    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
