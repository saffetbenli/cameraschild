import LicenseGenerators.FileGenerator;
import LicenseGenerators.RandomGenerator;
import org.springframework.beans.factory.annotation.Value;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

public class Output {
    @Value("${basisfrequentie}")
    static int basisFreq;
    @Value("${spitsfrequentie}")
    static int spitsFreq;
    @Value("${modus}")
    static String modus;


    static Calendar rightNow = Calendar.getInstance();
    static int hour = rightNow.get(Calendar.HOUR_OF_DAY);

    public static void main(String[] args) {
            while (true) {
                String licensePlate = "";

                RandomGenerator random = new RandomGenerator();
                FileGenerator file = new FileGenerator();

                if(modus.equals("random")){
                    licensePlate = random.getRandomLicensePlate();

                }else if (modus.equals("file")){

                }

                try {
                    if(modus.equals("random")){
                        if (hour >=7 && hour <= 9 || hour >=16 && hour <= 20){
                        Thread.sleep(1000);
                        }else{
                        Thread.sleep(500);
                        }
                    }else if (modus.equals("file")){
                        if (hour >=7 && hour <= 9 || hour >=16 && hour <= 20){
                            Thread.sleep(spitsFreq);
                        }else{
                            Thread.sleep(basisFreq);
                        }                    }
                    } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}