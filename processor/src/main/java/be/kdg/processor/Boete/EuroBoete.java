package be.kdg.processor.Boete;

import be.kdg.processor.config.Config;
import be.kdg.processor.dom.Message;
import be.kdg.processor.receiver.Receiver;
import be.kdg.processor.services.CameraService;
import be.kdg.processor.services.LicenseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EuroBoete implements Boete {
    private static final Logger LOG = LoggerFactory.getLogger(SnelheidsBoete.class);
    private CameraService cameraService;
    private LicenseService licenseService;
    private Receiver receiver;
    private Config config;

    public EuroBoete(CameraService cameraService, LicenseService licenseService, Receiver receiver, Config config) {
        this.cameraService = cameraService;
        this.licenseService = licenseService;
        this.receiver = receiver;
        this.config = config;
    }

    @Override
    public boolean findOut() {
        Message message = receiver.pullMessage();
        int minEuro = cameraService.getEuro(message.getId());
        int huidigeEuronorm = licenseService.getEuro(message.getLicencePlate());

        if (huidigeEuronorm == 0) {
            LOG.info("Geen lage emissiezone");
            return false;
        } else if (minEuro > huidigeEuronorm) {
            LOG.info("Auto met nummerplaat " + message.getLicencePlate() + " is NIET geschikt om in deze zone te rijden.");
            LOG.info("Gedetecteerde eurozone: "+ huidigeEuronorm+".Boete bedraagt:€ "+ berekenBoete());

            return true;
        } else {
            LOG.info("Auto is geschikt om in deze zone te rijden");
            return false;
        }
    }

    public double berekenBoete() {
        double boete = (config.getEmBasisprijs() * config.getEmBoetefactor());
        return boete;
    }
}
