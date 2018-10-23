package be.kdg.processor.Boete;

import be.kdg.processor.config.Config;
import be.kdg.processor.dom.CameraMessage;

import be.kdg.processor.services.CameraService;
import be.kdg.processor.services.LicenseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EuroBoete implements Boete {

    private static final Logger LOG = LoggerFactory.getLogger(SnelheidsBoete.class);
    private CameraService cameraService;
    private LicenseService licenseService;
    private int minEuro;
    private int huidigeEuronorm;
    private boolean magRijden;
    private Config config;


    public EuroBoete() {
        cameraService = new CameraService();
        licenseService = new LicenseService();
        config = new Config();
    }

    @Autowired
    public EuroBoete(CameraService cameraService, LicenseService licenseService, Config config) {
        this.cameraService = cameraService;
        this.licenseService = licenseService;
        this.config = config;
    }

    public boolean findOut(CameraMessage cameraMessage) {
            minEuro =  cameraService.getEuro(cameraMessage.getCameraId());
            huidigeEuronorm = licenseService.getEuro(cameraMessage.getLicensePlate());

            if (minEuro == 0) {
                LOG.info("Geen lage emissiezone");
                magRijden = true;
            } else if (minEuro > huidigeEuronorm) {
                LOG.info("Auto met nummerplaat " + cameraMessage.getLicensePlate() + " is NIET geschikt om in deze zone te rijden.");
                LOG.info("Gedetecteerde eurozone: "+ huidigeEuronorm+". Boete bedraagt:€ " + berekenBoete());
                magRijden = false;
            } else {
                LOG.info("Auto is geschikt om in deze zone te rijden");
                magRijden = true;
            }
            return magRijden;
    }

    public int berekenBoete(){
        return config.getEmBasisprijs() * config.getEmBoetefactor();
    }
}
