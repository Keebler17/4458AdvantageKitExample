// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import subsystems.drive.Drive;

/** Add your docs here. */
public class TeleopCommand extends Command {

    Drive drive;

    XboxController controller = new XboxController(0);

    int leftYAxis = 1;
    int rightXAxis = 2;

    public TeleopCommand(Drive drive) {
        this.drive = drive;
        addRequirements(drive);
    }

    @Override
    public void execute() {
        drive.arcadeDrive(controller.getRawAxis(leftYAxis), controller.getRawAxis(rightXAxis));
    }

    @Override
    public void end(boolean interrupted) {
        drive.arcadeDrive(0, 0);
    }
}
