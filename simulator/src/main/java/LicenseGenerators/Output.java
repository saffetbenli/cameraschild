package LicenseGenerators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class Output {

    private int spitsFreq;
    private int basisFreq;

    static Calendar rightNow = Calendar.getInstance();
    static int hour = rightNow.get(Calendar.HOUR_OF_DAY);



    String out = new String();


    /*

    public String get(){
        while (true) {
            String licensePlate = "";

            LicenseGenerators.RandomGenerator random = new LicenseGenerators.RandomGenerator();

            if(config.getModus().equals("random")){
                licensePlate = random.getRandomLicensePlate();

                return "File";
            }else if (config.getModus().equals("file")){
                return "Random";
            }

            try {
                if(config.getModus().equals("random")){
                    if (hour >=7 && hour <= 9 || hour >=16 && hour <= 20){
                        Thread.sleep(1000);
                    }else{
                        Thread.sleep(500);
                    }
                }else if (config.getModus().equals("file")){
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
    */
}
