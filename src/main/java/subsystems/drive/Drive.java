// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package subsystems.drive;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import subsystems.Constants;

/** Add your docs here. */
public class Drive extends SubsystemBase {

    private final DriveIO io; 
    private DriveIOInputsAutoLogged inputs = new DriveIOInputsAutoLogged();

    DifferentialDriveKinematics kinematics;
    DifferentialDriveOdometry odometry;
    DifferentialDrive drive;

    public Drive(DriveIO io) {
        this.io = io;
        kinematics = new DifferentialDriveKinematics(Constants.kTrackWidth);
        odometry = new DifferentialDriveOdometry(new Rotation2d(), 0, 0);
    }

    @Override
    public void periodic() {
        io.updateInputs(inputs);
        Logger.processInputs("Drive", inputs);
    }
    
    public void driveVolts(double leftV, double rightV) {
        io.driveVolts(leftV, rightV);
    }

    public void arcadeDrive(double x, double omega) {
        io.arcadeDrive(x, omega);
    }
}
