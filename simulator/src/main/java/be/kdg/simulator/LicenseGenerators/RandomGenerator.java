package be.kdg.simulator.LicenseGenerators;

import be.kdg.simulator.Model.CameraMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

@Component
public class RandomGenerator implements LicensePlateGenerator  {
    private static final Logger LOG = LoggerFactory.getLogger(RandomGenerator.class);
    private Random random = new Random();

    public  int getRandomCameraId(){
        int cameraId = random.nextInt(5) + 1;
        return cameraId;
    }

    public  int getRandomLicensePlateNumber() {
        int licensePlate1 = random.nextInt(9) + 1 ;
        return licensePlate1;
    }

    public  char getRandomLicensePlateLetter() {
        char licensePlate4 = (char) ( (random.nextInt(25) + 1) + 'a');
        return licensePlate4;
    }


    @Override
    public CameraMessage generate() {
        LOG.info("Random license generated");
        return new CameraMessage(getRandomCameraId(),
                String.format("%d-%c%c%c-%d%d%d", getRandomLicensePlateNumber(), getRandomLicensePlateLetter(), getRandomLicensePlateLetter(),
                getRandomLicensePlateLetter(), getRandomLicensePlateNumber(), getRandomLicensePlateNumber(), getRandomLicensePlateNumber()).toUpperCase(),LocalDateTime.now());
    }

    @Override
    public int getDelay() {
        return 0;
    }
}
