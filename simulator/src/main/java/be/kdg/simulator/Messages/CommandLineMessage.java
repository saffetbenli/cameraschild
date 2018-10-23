package be.kdg.simulator.Messages;

import be.kdg.simulator.LicenseGenerators.RandomGenerator;
import be.kdg.simulator.Model.CameraMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CommandLineMessage implements MessageSender {
    private static final Logger LOG = LoggerFactory.getLogger(CommandLineMessage.class);

    @Override
    public void sendMessage(CameraMessage cameraMessage) {
        LOG.info("Message send on commandline");
        System.out.println(cameraMessage);
    }
}
