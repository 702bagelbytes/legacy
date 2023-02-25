/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveTurn extends Command {
  int turnDirection;
  int turnLength;
  double turnSpeed;
  // default 1, 20, 0.7
  public DriveTurn(int turnDirection1, int turnLength1, double turnSpeed1 ) {
    requires(Robot.drive);
    this.turnDirection = -1*turnDirection1;
    this.turnSpeed = turnSpeed1;
    this.turnLength = turnLength1;
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
    Robot.drive.driveTurn(turnDirection, turnSpeed);
    System.out.println("DriveTurn; Left: " + Robot.drive.getLeftPos() + " Right: " + Robot.drive.getRightPos());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(turnDirection == 1) { // turning right
      if(Robot.drive.getLeftPos() > turnLength || Robot.drive.getRightPos() < -1 * turnLength) {
        return true;
      }
    }if(turnDirection == -1) { // turning left
      if(Robot.drive.getLeftPos() > turnLength * -1 || Robot.drive.getRightPos() < turnLength) {
        return true;
      }
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
