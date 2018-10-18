package LicenseGenerators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GeneratorInvocator{
    private LicensePlateGenerator messageGenerator;

    @Autowired
    public GeneratorInvocator (@Qualifier("generateRandom") RandomGenerator randomGenerator, @Qualifier("generateFile") FileGenerator fileGenerator,@Value("${modus}") String modus){
        if (modus.equalsIgnoreCase("random")) {
            this.messageGenerator = randomGenerator;
        }else if (modus.equalsIgnoreCase("file")) {
            this.messageGenerator = fileGenerator;
        }
    }

    public LicensePlateGenerator getMessageGenerator() {
        return messageGenerator;
    }
}

