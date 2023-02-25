package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
    private final CANSparkMax leftSpark1 = new CANSparkMax(1, MotorType.kBrushed);
    private final CANSparkMax leftSpark2 = new CANSparkMax(2, MotorType.kBrushed);
    private final CANSparkMax leftSpark3 = new CANSparkMax(3, MotorType.kBrushed);
    private final WPI_TalonSRX leftTalon1 = new WPI_TalonSRX(33);
    private final WPI_TalonSRX leftTalon2 = new WPI_TalonSRX(35);
    private final MotorControllerGroup left = new MotorControllerGroup(leftTalon1, leftTalon2);
   
    private final WPI_TalonSRX rightTalon1 = new WPI_TalonSRX(36);
    private final WPI_TalonSRX rightTalon2 = new WPI_TalonSRX(31);
    
    private final MotorControllerGroup right = new MotorControllerGroup(rightTalon1, rightTalon2);
    private final DifferentialDrive driveTrain = new DifferentialDrive(left, right);
    // this is one way to do it
    private boolean isTankDrive = true;

    public DriveSubsystem() {
        leftSpark1.setIdleMode(IdleMode.kBrake);
        leftSpark2.setIdleMode(IdleMode.kBrake);
        leftSpark3.setIdleMode(IdleMode.kBrake);
        leftTalon1.setNeutralMode(NeutralMode.Brake);
        leftTalon2.setNeutralMode(NeutralMode.Brake);
        rightTalon2.setNeutralMode(NeutralMode.Brake);
        rightTalon1.setNeutralMode(NeutralMode.Brake);
    }

    public void tankDrive(double leftSpeed, double rightSpeed) {
        driveTrain.tankDrive(leftSpeed * .9, rightSpeed * .9);
    }

    public void arcadeDrive(double xSpeed, double zRotation) {
        driveTrain.arcadeDrive(xSpeed, zRotation);
    }

    public void toggleDriveMode() {
        isTankDrive = !isTankDrive;
    }

    public void setIsTankDrive(boolean mode) {
        isTankDrive = mode;
    }

    public boolean isTankDrive() {
        return isTankDrive;
    }

    public void switchedDrive(double a, double b) {
        if (isTankDrive) {
            tankDrive( a, b );
        } else {
            arcadeDrive(a, b);
        }
    }
}
