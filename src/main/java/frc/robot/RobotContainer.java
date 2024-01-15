// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.commands.TeleopCommand;
import subsystems.drive.Drive;
import subsystems.drive.DriveIOPWMSparkMax;
import subsystems.drive.DriveIOSim;

/** Add your docs here. */
public class RobotContainer {

    Drive drive;
    TeleopCommand teleopCommand;

    public RobotContainer() {
        if(Robot.isReal())
            drive = new Drive(new DriveIOPWMSparkMax());
        if(Robot.isSimulation())
            drive = new Drive(new DriveIOSim());

        teleopCommand = new TeleopCommand(drive);

        configureButtonBindings();
    }

    public void configureButtonBindings() {
        drive.setDefaultCommand(teleopCommand);
    }

    public Command getAutonomousCommand() {
        return Commands.none();
    }

}
