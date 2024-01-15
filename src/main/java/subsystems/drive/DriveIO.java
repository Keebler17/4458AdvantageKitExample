// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package subsystems.drive;

import org.littletonrobotics.junction.AutoLog;

/** Add your docs here. */
public interface DriveIO {
    @AutoLog
    public static class DriveIOInputs {
        public double leftVolts = 0.0;
        public double leftEncoder = 0.0;

        public double rightVolts = 0.0;
        public double rightEncoder = 0.0;

        public double yaw = 0.0;
    }
    
    public default void updateInputs(DriveIOInputs inputs) {}
    public default void driveVolts(double leftV, double rightV) {}
    public default void arcadeDrive(double x, double omega) {}
}
