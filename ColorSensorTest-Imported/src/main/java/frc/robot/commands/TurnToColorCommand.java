/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class TurnToColorCommand extends Command {
  int step = 0;
  String targetColor;
  int waitTime;
  public TurnToColorCommand(String TargetColor) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.colorWheel);
    targetColor = TargetColor;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    step = 1;
    waitTime = 25;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //SmartDashboard.putString("color", Robot.colorWheel.getSensorColor());
    //System.out.println("Detected color:" + Robot.colorWheel.getSensorColor());
    String colorSensed =Robot.colorWheel.getSensorColor();
    System.out.println("Step: " + step + " Color sensed: " + colorSensed);
    SmartDashboard.putString("Blue", colorSensed);

    if(step == 1) { // TURN TO COLOR ONCE
      if(colorSensed == targetColor) {
        step = 2;
        System.out.println("end step 1");
      } else {
        Robot.colorWheel.drive(.3);
      }
    } else if(step == 2) { // WAIT



      waitTime--;
      Robot.colorWheel.drive(0);
      System.out.println("Wait time: " + waitTime);
      if(waitTime == 0) {
        step = 3;
        System.out.println("end the waiter");
      }
    } else if(step == 3) { // GO BACKWARDS IF NECESSARY
      if(colorSensed == targetColor) {
        step = 4;
        System.out.println("END step4");
        Robot.colorWheel.drive(0);

      } else {
        Robot.colorWheel.drive(-0.2);
        
      }
    } else if(step == 4) { // END
      System.out.println("ENDDDD");
      end();
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(step == 4) {
      return true;
    }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    step = 0;
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
