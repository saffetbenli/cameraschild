package BoeteBereken;

import be.kdg.sa.services.CameraServiceProxy;
import be.kdg.se3.services.LicensePlateServiceProxy;
import javafx.scene.Camera;

import java.io.IOException;

public class BerekenBoete {
    private String nrPlate = "www.services4se3.com/license-plate/1-AAA-999";
    private LicensePlateServiceProxy proxy = new LicensePlateServiceProxy();
    private CameraServiceProxy cameraServiceProxy = new CameraServiceProxy();

    public String bereken() throws IOException {
        return proxy.get(nrPlate);
    }

    public String getboete() throws IOException {
        return cameraServiceProxy.get(1);
    }
}
