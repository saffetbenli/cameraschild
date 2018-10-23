package be.kdg.simulator.LicenseGenerators;

import be.kdg.simulator.Model.CameraMessage;

public interface LicensePlateGenerator {
    CameraMessage generate();
    int getDelay();
}
