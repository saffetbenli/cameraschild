package be.kdg.processor.Boete;

import be.kdg.processor.config.Config;
import be.kdg.processor.dom.Message;
import be.kdg.processor.receiver.Receiver;
import be.kdg.processor.services.CameraService;
import be.kdg.processor.services.LicenseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SnelheidsBoete implements Boete {
    private static final Logger LOG = LoggerFactory.getLogger(SnelheidsBoete.class);
    private CameraService cameraService;
    private LicenseService licenseService;
    private Receiver receiver;
    private Config config;

    public SnelheidsBoete(CameraService cameraService, LicenseService licenseService, Receiver receiver, Config config) {
        this.cameraService = cameraService;
        this.licenseService = licenseService;
        this.receiver = receiver;
        this.config = config;
    }

    @Override
    public boolean findOut() {
    return false;
    }

    public double berekenBoete() {
        return 0.0;
    }
}
