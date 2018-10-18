package be.kdg.processor.receiver;

import be.kdg.processor.config.Config;
import be.kdg.processor.dom.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    private static final Logger LOG = LoggerFactory.getLogger(Receiver.class);
    private Config config;
    private RabbitTemplate rabbitTemplate;


    @Autowired
    public Receiver(RabbitTemplate rabbitTemplate, Config config) {
        this.rabbitTemplate = rabbitTemplate;
        this.config = config;
    }

    public Message pullMessage() {
        LOG.info("message received");
        String message = rabbitTemplate.receiveAndConvert(config.getQUEUE_NAME()).toString();

        //String splitMessage[] = message.toString().split(",");
        Message cameraMessage = (Message) message;
        LOG.info("Converted Message:" + cameraMessage);
        // CameraMessage cameraMessage = new CameraMessage(Integer.parseInt(splitMessage[0]),splitMessage[1], LocalDateTime.parse(splitMessage[2]));
        return cameraMessage;
    }
}