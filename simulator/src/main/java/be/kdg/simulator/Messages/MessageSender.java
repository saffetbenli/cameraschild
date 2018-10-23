package be.kdg.simulator.Messages;

import be.kdg.simulator.Model.CameraMessage;

import javax.xml.bind.JAXBException;

public interface MessageSender {
    void sendMessage(CameraMessage cameraMessage);
}
