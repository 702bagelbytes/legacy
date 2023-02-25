package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
    private WPI_TalonSRX frontLeft = new WPI_TalonSRX(21);
    private WPI_TalonSRX frontRight = new WPI_TalonSRX(29);
    private WPI_TalonSRX backLeft = new WPI_TalonSRX(30);
    private WPI_TalonSRX backRight = new WPI_TalonSRX(27);
    private MecanumDrive drive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight); 

    public DriveSubsystem () {
        frontRight.setInverted(true);
        backRight.setInverted(true);
    }

    public void driveCartesian(double ySpeed, double xSpeed, double zRotation) {
        drive.driveCartesian(ySpeed, xSpeed, zRotation);
    }
}
