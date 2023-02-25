/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class AUTO_balltracking extends Command {
  
  public NetworkTableEntry ball_direction;
  public NetworkTableEntry ball_difference;
  public NetworkTableEntry ball_radius;
  public NetworkTableEntry ball_found;
  // ball_auto
 
  public AUTO_balltracking() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_drive);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    // added here:
    //inst.startDSClient();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    NetworkTableInstance inst = NetworkTableInstance.getDefault();
    NetworkTable table = inst.getTable("datatable");

    ball_direction = table.getEntry("b_direction");
    ball_difference = table.getEntry("b_difference");
    ball_radius = table.getEntry("b_radius");
    ball_found = table.getEntry("b_found");

    boolean ballFound = ball_found.getBoolean(false);
    if(ballFound) {
      int turnDir = Integer.parseInt(ball_direction.getString("0"));
      double difference = Math.abs( (double)Integer.parseInt(ball_difference.getString("0"))); // this is from 40 to 160
      int radius = (int) Integer.parseInt(ball_radius.getString("0"));

      double turnSpeed = (double)difference / 160;
      double forwardSpeed = 0;
      if(radius < 100) {
        forwardSpeed = 0.5;
      }
      Robot.m_drive.driveTurn(turnDir, turnSpeed, forwardSpeed);
      System.out.println("> > forward: " + forwardSpeed + " turnDir: " + turnDir + " turnSpeed: " + turnSpeed);
      
      System.out.println("turnDir:" + turnDir + "\tdifference:" + difference + "\tradius:" + radius);
    } else {
      Robot.m_drive.driveTurn(0, 0, 0);
      System.out.println("ball not found");
    }
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
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
