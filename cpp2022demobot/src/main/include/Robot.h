// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

#pragma once

#include <string>

#include <frc/TimedRobot.h>
#include <frc/smartdashboard/SendableChooser.h>
#include <frc/drive/MecanumDrive.h>
#include <frc/XboxController.h>
#include <ctre/Phoenix.h>
#include <rev/CANSparkMax.h>

class Robot : public frc::TimedRobot {
 public:
  void RobotInit() override;
  void RobotPeriodic() override;
  void AutonomousInit() override;
  void AutonomousPeriodic() override;
  void TeleopInit() override;
  void TeleopPeriodic() override;
  void DisabledInit() override;
  void DisabledPeriodic() override;
  void TestInit() override;
  void TestPeriodic() override;

 private:
  frc::SendableChooser<std::string> m_chooser;
  const std::string kAutoNameDefault = "Default";
  const std::string kAutoNameCustom = "My Auto";
  std::string m_autoSelected;

  WPI_TalonSRX talonFL{21};
  WPI_TalonSRX talonFR{29};
  rev::CANSparkMax sparkBL{2, rev::CANSparkMax::MotorType::kBrushed};
  rev::CANSparkMax sparkBR{1, rev::CANSparkMax::MotorType::kBrushed};
  frc::MecanumDrive drive{talonFL, sparkBL, talonFR, sparkBR};

  frc::XboxController stick{0};
};
