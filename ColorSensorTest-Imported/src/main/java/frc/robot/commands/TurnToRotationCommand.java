/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TurnToRotationCommand extends Command {
  int targetSenseCount;
  public TurnToRotationCommand(int TargetSenseCount) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.colorWheel);
    targetSenseCount = TargetSenseCount;
  }
  int fullRotations;
  boolean onRed;
  String currentColor;
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    fullRotations = 0;
    currentColor =Robot.colorWheel.getSensorColor();
    onRed = currentColor == "RED";
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    currentColor =Robot.colorWheel.getSensorColor();
    SmartDashboard.putString("COLOR: ", currentColor);
    SmartDashboard.putNumber("full rotations: ", fullRotations);
    if(fullRotations < targetSenseCount) {
      Robot.colorWheel.drive(.3);
      if(currentColor == "RED") {
        if(onRed == false) {
          onRed = true;
          fullRotations++;
        } 
      }
      if(currentColor != "RED" && onRed == true) {
        onRed = false;
      }
    }
    SmartDashboard.putNumber("full rotations: ", fullRotations);

    if(fullRotations >= targetSenseCount) {
      Robot.colorWheel.drive(0);
      end();
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(fullRotations >= targetSenseCount) {
      Robot.colorWheel.drive(0);
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
