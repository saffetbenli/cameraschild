package LicenseGenerators;

import Model.CameraMessage;

import java.time.LocalDateTime;
import java.util.Random;

public class RandomGenerator implements LicensePlateGenerator  {
    Random random = new Random();

    public  int getRandomCameraId(){
        int cameraId = random.nextInt(14) + 1;
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
        return new CameraMessage(getRandomCameraId(),
                String.format("%d-%c%c%c-%d%d%d", getRandomLicensePlateNumber(), getRandomLicensePlateLetter(), getRandomLicensePlateLetter(),
                getRandomLicensePlateLetter(), getRandomLicensePlateNumber(), getRandomLicensePlateNumber(), getRandomLicensePlateNumber()).toUpperCase(),LocalDateTime.now());
    }
}
