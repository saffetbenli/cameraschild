package be.kdg.processor.services;

import be.kdg.processor.Json.JsonParser;
import be.kdg.sa.services.CameraServiceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.json.JsonObject;
import java.io.IOException;

@Component
public class CameraService {
    private static final Logger LOG = LoggerFactory.getLogger(CameraService.class);
    private CameraServiceProxy cameraServiceProxy;
    private JsonParser parser;
    private int euro;

    @Autowired
    public CameraService(CameraServiceProxy cameraServiceProxy,JsonParser parser) {
        this.cameraServiceProxy = cameraServiceProxy;
        this.parser=parser;
    }

    public int getEuro(int id){
        JsonObject object;
        try {
            object = parser.convert(cameraServiceProxy.get(id));
            euro=object.getInt("euroNorm",0);
        } catch (IOException e) {
            e.printStackTrace();
            LOG.error("Error in the id of the message or in the reading of the json object", e);
        }
        return euro;
    }
}
