package Messages;

import Model.CameraMessage;

import javax.xml.bind.JAXBException;

public interface MessageSender {
    void sendMessage(CameraMessage cameraMessage) throws JAXBException;
}
