package LicenseGenerators;

import Model.CameraMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
        import java.io.FileNotFoundException;
        import java.io.FileReader;
        import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class FileGenerator implements LicensePlateGenerator{
    @Value("${filePath}")
    private String filePath;
    private int[] cameras;
    private String[] licences;
    private int[] frequencies;
    private int quantityOfPlates = 0;

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
                        cameras[i] = Integer.parseInt(licensePlate[j]);
                    }else if (j == 1){
                        licences[i] = licensePlate[j];
                    }else if (j == 2){
                        frequencies[i] = Integer.parseInt(licensePlate[j]);
                    }
                }
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
        return new CameraMessage(cameras[quantityOfPlates], frequencies[quantityOfPlates], licences[quantityOfPlates++], LocalDateTime.now());
    }
}
