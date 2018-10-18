package be.kdg.processor.config;

import be.kdg.sa.services.CameraServiceProxy;
import be.kdg.sa.services.LicensePlateServiceProxy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    private String QUEUE_NAME = "licences";

    @Value("${em.basisprijs}")
    private int emBasisprijs;
    @Value("${em.boetefactor}")
    private int emBoetefactor;

    public int getEmBasisprijs() {
        return emBasisprijs;
    }

    public int getEmBoetefactor() {
        return emBoetefactor;
    }

    @Bean
    public CameraServiceProxy cameraServiceProxy(){ return new CameraServiceProxy();}
    @Bean
    public LicensePlateServiceProxy licensePlateServiceProxy(){ return new LicensePlateServiceProxy();}

    public String getQUEUE_NAME() {
        return QUEUE_NAME;
    }
}
