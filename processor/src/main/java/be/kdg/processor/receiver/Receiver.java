package be.kdg.processor.receiver;

import be.kdg.processor.Boete.EuroBoete;
import be.kdg.processor.parsers.XMLParser;
import be.kdg.processor.dom.CameraMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;


@Component
public class Receiver {
    private static final Logger LOG = LoggerFactory.getLogger(Receiver.class);
    private XMLParser xmlParser = new XMLParser();
    private CameraMessage cameraMessage;
    private EuroBoete boete = new EuroBoete();

    public void receiveMessage(String message){
        LOG.info("receiving the message ");
        cameraMessage = xmlParser.readMessage(message);
        boete.findOut(cameraMessage);
    }

    public CameraMessage getCameraMessage() {
        return cameraMessage;
    }

}