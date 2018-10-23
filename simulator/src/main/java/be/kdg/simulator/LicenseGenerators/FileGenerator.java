package be.kdg.simulator.LicenseGenerators;

import be.kdg.simulator.Model.CameraMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
        import java.io.FileNotFoundException;
        import java.io.FileReader;
        import java.io.IOException;

@Component
public class FileGenerator implements LicensePlateGenerator{
    private static final Logger LOG = LoggerFactory.getLogger(FileGenerator.class);
    private Environment env;
    private String filePath ;
    private String[] cameras =  new String[10];
    private String[] licences=  new String[10];
    private String[] frequencies =  new String[10];
    private int quantityOfPlates = 0;

    @Autowired
    public FileGenerator(Environment env) {
        this.env = env;
        filePath = env.getProperty("filePath");
    }

    @Override
    public CameraMessage generate() {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        int quantity;
        try {
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                int i = 0;
                String[] licensePlate = line.split(cvsSplitBy);

                for (int j = 0; j < 3; j++) {
                    if (j == 0){
                        cameras[i] = licensePlate[j];
                    }else if (j == 1){
                        licences[i] = licensePlate[j];
                    }else if (j == 2){
                        frequencies[i] = licensePlate[j];
                    }
                }
                LOG.info("License from file generated");
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
      //  return new CameraMessage(Integer.parseInt(cameras[quantityOfPlates]), Integer.parseInt(frequencies[quantityOfPlates]), licences[quantityOfPlates++], LocalDateTime.now());
    return null;
    }

    @Override
    public int getDelay() {
        return 0;
    }
}
