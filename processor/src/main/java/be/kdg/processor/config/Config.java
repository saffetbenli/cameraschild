package be.kdg.processor.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Config {
    private Environment env;
    public int emBasisprijs = 50;
    public int emBoetefactor = 2;

    public Config() {
    }

    @Autowired
    public Config(Environment env) {
        this.env = env;
    }

    public int getEmBasisprijs() {
        return emBasisprijs;
    }

    public int getEmBoetefactor() {
        return emBoetefactor;
    }
}
