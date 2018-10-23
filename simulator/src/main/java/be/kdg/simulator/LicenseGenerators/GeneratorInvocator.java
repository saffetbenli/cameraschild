package be.kdg.simulator.LicenseGenerators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class GeneratorInvocator{
    private LicensePlateGenerator messageGenerator;
    private Environment env;
    private String modus;

    @Autowired
    public GeneratorInvocator (@Qualifier("randomGenerator") RandomGenerator randomGenerator,
                               @Qualifier("fileGenerator") FileGenerator fileGenerator,
                               Environment env){
        this.env = env;
        modus = env.getProperty("modus");
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

