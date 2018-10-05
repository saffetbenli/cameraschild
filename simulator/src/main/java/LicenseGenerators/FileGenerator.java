package LicenseGenerators;

import org.springframework.beans.factory.annotation.Value;

import java.io.BufferedReader;
        import java.io.FileNotFoundException;
        import java.io.FileReader;
        import java.io.IOException;

public class FileGenerator {
    @Value("${csv.path}")
    String csvFile;

    private int[] cameras;
    private String[] licences;
    private int[] frequencies;

    public void readLicencesFromFile() {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            br = new BufferedReader(new FileReader(csvFile));
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
    }

     public int[] getCameras(){
        readLicencesFromFile();
        return cameras;
    }

    public String[] getLicences(){
        readLicencesFromFile();
        return licences;
    }

    public int[] getFrequency(){
        readLicencesFromFile();
        return frequencies;
    }

}
