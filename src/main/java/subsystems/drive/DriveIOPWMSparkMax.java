// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package subsystems.drive;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import subsystems.Constants;

/** Add your docs here. */
public class DriveIOPWMSparkMax implements DriveIO {

    PWMSparkMax l;
    PWMSparkMax r;

    Encoder encoderL;
    Encoder encoderR;

    DifferentialDrive drive;

    AnalogGyro gyro;

    public DriveIOPWMSparkMax() {
        l = new PWMSparkMax(Constants.LEFT_MOTOR);
        r = new PWMSparkMax(Constants.RIGHT_MOTOR);

        r.setInverted(true);
        
        encoderL = new Encoder(Constants.LEFT_ENCODER_0, Constants.LEFT_ENCODER_1);
        encoderR = new Encoder(Constants.RIGHT_ENCODER_0, Constants.RIGHT_ENCODER_1);

        encoderL.setDistancePerPulse(Constants.distancePerPulse);
        encoderR.setDistancePerPulse(Constants.distancePerPulse);

        encoderR.setReverseDirection(true);

        drive = new DifferentialDrive(l, r);

        gyro = new AnalogGyro(Constants.GYRO);
    }

    @Override
    public void updateInputs(DriveIOInputs inputs) {
        inputs.leftVolts = l.get() * RobotController.getBatteryVoltage();
        inputs.leftEncoder = encoderL.getDistance();

        inputs.rightVolts = r.get() * RobotController.getBatteryVoltage();
        inputs.rightEncoder = encoderR.getDistance();

        inputs.yaw = getHeading();
    }

    @Override
    public void driveVolts(double leftV, double rightV) {
        l.setVoltage(leftV);
        r.setVoltage(rightV);
        drive.feed();
    }

    @Override
    public void arcadeDrive(double x, double omega) {
        drive.arcadeDrive(x, omega);
    }

    protected double getHeading() {
        return gyro.getAngle();
    }
}
