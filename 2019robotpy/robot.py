import wpilib
import wpilib.drive
import ctre

TALON_FL = 35
TALON_FR = 33
TALON_BL = 36
TALON_BR = 31

LEFT_HAND = wpilib.interfaces.GenericHID.Hand.kLeftHand
RIGHT_HAND = wpilib.interfaces.GenericHID.Hand.kRightHand


class MyRobot(wpilib.TimedRobot):
    def robotInit(self) -> None:
        self.fl = ctre.WPI_TalonSRX(TALON_FL)
        self.fr = ctre.WPI_TalonSRX(TALON_FR)
        self.bl = ctre.WPI_TalonSRX(TALON_BL)
        self.br = ctre.WPI_TalonSRX(TALON_BR)
        self.drive = wpilib.drive.MecanumDrive(self.fl, self.bl, self.fr, self.br)
        self.stick = wpilib.XboxController(0)

    def teleopInit(self) -> None:
        print("TELEOP INIT")

    def teleopPeriodic(self) -> None:
        self.drive.driveCartesian(
            self.stick.getX(LEFT_HAND), # ySpeed (strafe)
            self.stick.getY(LEFT_HAND) * -1, # xSpeed (drive)
            self.stick.getX(RIGHT_HAND), # zRotation (rotate)
        )


if __name__ == "__main__":
    wpilib.run(MyRobot)
