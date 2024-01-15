// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package subsystems.drive;

import edu.wpi.first.math.VecBuilder;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.AnalogGyroSim;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.simulation.EncoderSim;
import subsystems.Constants;

/** Add your docs here. */
public class DriveIOSim extends DriveIOPWMSparkMax {

    DifferentialDrivetrainSim sim;

    EncoderSim lSim;
    EncoderSim rSim;

    AnalogGyroSim gyroSim;

    public DriveIOSim() {
        super();

        lSim = new EncoderSim(encoderL);
        rSim = new EncoderSim(encoderR);

        gyroSim = new AnalogGyroSim(gyro);
    
        sim = new DifferentialDrivetrainSim(
            DCMotor.getCIM(1),
            Constants.kDriveRatio,
            Constants.kMOI,
            Constants.kMass,
            Constants.kWheelRadius,
            Constants.kTrackWidth,
            VecBuilder.fill(0.001, 0.001, 0.001, 0.1, 0.1, 0.005, 0.005)
        );
    }

    @Override
    public void updateInputs(DriveIOInputs inputs) {
        sim.setInputs(inputs.leftVolts, inputs.rightVolts);
        sim.update(0.02);

        lSim.setDistance(sim.getLeftPositionMeters());
        rSim.setDistance(sim.getRightPositionMeters());

        lSim.setRate(sim.getLeftVelocityMetersPerSecond());
        rSim.setRate(sim.getRightVelocityMetersPerSecond());

        gyroSim.setAngle(sim.getHeading().getDegrees());
        
        super.updateInputs(inputs);
    }

    @Override
    protected double getHeading() {
        return sim.getHeading().getDegrees();
    }
}
