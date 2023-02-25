package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends CommandBase {
    private final DriveSubsystem driveSubsystem;
    private final DoubleSupplier left;
    private final DoubleSupplier right;

    public DriveCommand(
        DriveSubsystem driveSubsystem, 
        DoubleSupplier left,
        DoubleSupplier right
    ) {
        this.driveSubsystem = driveSubsystem;
        addRequirements(driveSubsystem);
        this.left = left;
        this.right = right;
    }

    @Override
    public void execute() {
        driveSubsystem.switchedDrive(left.getAsDouble(), right.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        driveSubsystem.switchedDrive(0, 0);
    }
}
