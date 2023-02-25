/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.TurnToColorCommand;
import frc.robot.commands.TurnToRotationCommand;
import frc.robot.commands.ColorStopCommand;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public Joystick controller = new Joystick(0);
  public Button bblue;
  public Button bred;
  public Button byellow;
  public Button bgreen;
  public Button bL;
  public Button bR;
  public Joystick getJoystick() {
    return controller;
  }

  public void init() {
    bblue = new JoystickButton(controller, RobotMap.buttonBlue);
    bred = new JoystickButton(controller, RobotMap.buttonRed);
    byellow = new JoystickButton(controller, RobotMap.buttonYellow);
    bgreen = new JoystickButton(controller, RobotMap.buttonGreen);
    bR = new JoystickButton(controller, RobotMap.bumperR);
    bL = new JoystickButton(controller, RobotMap.bumperL);
    bblue.whenPressed(new TurnToColorCommand("BLUE"));
    bred.whenPressed(new TurnToColorCommand("RED"));    
    byellow.whenPressed(new TurnToColorCommand("YELLOW"));
    bgreen.whenPressed(new TurnToColorCommand("GREEN"));
    bR.whenPressed(new TurnToRotationCommand(7));
    bL.whenPressed(new ColorStopCommand());
  }
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());
  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
