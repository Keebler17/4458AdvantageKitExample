// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package subsystems;

import edu.wpi.first.math.util.Units;

/** Add your docs here. */
public class Constants {
    public static final double kTrackWidth = 0.7112;
    
    public static final double kDriveRatio = 10.71;
    public static final double kMOI = 7.5;
    public static final double kMass = 60.0;
    public static final double kWheelRadius = Units.inchesToMeters(3);

    public static final double distancePerPulse = ((1.0/360.0) / 10.71) * (kWheelRadius * Math.PI);

    public static final int LEFT_MOTOR = 0;
    public static final int RIGHT_MOTOR = 1;

    public static final int LEFT_ENCODER_0 = 2;
    public static final int LEFT_ENCODER_1 = 3;

    public static final int RIGHT_ENCODER_0 = 4;
    public static final int RIGHT_ENCODER_1 = 5;

    public static final int GYRO = 0;
}
