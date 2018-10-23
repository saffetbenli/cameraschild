package be.kdg.processor.parsers;

import be.kdg.processor.dom.CameraMessage;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@Component
public class XMLParser {
    CameraMessage cameraMessage = null;

    public CameraMessage readMessage(String cameraMessageXml) {
        try {
            JAXBContext context = JAXBContext.newInstance(CameraMessage.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            StringReader reader = new StringReader(cameraMessageXml);
            cameraMessage = (CameraMessage) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return cameraMessage;
    }
}
