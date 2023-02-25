package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends CommandBase {
    DriveSubsystem drive;
    Supplier<Double> ySupplier;
    Supplier<Double> xSupplier;
    Supplier<Double> zSupplier;

    public DriveCommand(DriveSubsystem drive, Supplier<Double> ySupplier, Supplier<Double> xSupplier, Supplier<Double> zSupplier) {
        this.drive = drive;
        addRequirements(drive);
        this.ySupplier = ySupplier;
        this.xSupplier = xSupplier;
        this.zSupplier = zSupplier;
    }

    @Override
    public void execute() {
        drive.driveCartesian(ySupplier.get(), xSupplier.get(), zSupplier.get());
    }
}
