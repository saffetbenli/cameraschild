package be.kdg.processor.services;

import be.kdg.processor.Json.JsonParser;
import be.kdg.sa.services.LicensePlateServiceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.json.JsonObject;
import java.io.IOException;

@Component
public class LicenseService {
    private static final Logger LOG = LoggerFactory.getLogger(LicenseService.class);
    private LicensePlateServiceProxy licensePlateServiceProxy;
    private JsonParser parser;
    private int euro;


    @Autowired
    public LicenseService(LicensePlateServiceProxy licensePlateServiceProxy, JsonParser parser) {
        this.licensePlateServiceProxy = licensePlateServiceProxy;
        this.parser = parser;
    }

    public int getEuro(String license) {
        try {
            JsonObject object = parser.convert(licensePlateServiceProxy.get(license));
            euro = object.getInt("euroNumber", 0);
        } catch (IOException e) {
            e.printStackTrace();
            LOG.error("License not found!", e);
        }
        return euro;
    }
}
