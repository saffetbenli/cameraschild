package LicenseGenerators;

import java.util.Random;

public class RandomGenerator {
    Random random = new Random();
    String randomLicense = "";

    public  int getRandomCameraId(){
        int cameraId = random.nextInt(14) + 1;
        return cameraId;
    }

    public  int getRandomLicensePlateNumber() {
        int licensePlate1 = random.nextInt(10) + 1 ;
        return licensePlate1;
    }

    public  char getRandomLicensePlateLetter() {
        char licensePlate4 = (char) ( (random.nextInt(25) + 1) + 'a');
        return licensePlate4;
    }

    public String getRandomLicensePlate(){
        randomLicense = String.format("%d-%c%c%c-%d%d%d", getRandomLicensePlateNumber(), getRandomLicensePlateLetter(), getRandomLicensePlateLetter(),
                getRandomLicensePlateLetter(), getRandomLicensePlateNumber(), getRandomLicensePlateNumber(), getRandomLicensePlateNumber()).toUpperCase();
        return randomLicense;
    }
}
