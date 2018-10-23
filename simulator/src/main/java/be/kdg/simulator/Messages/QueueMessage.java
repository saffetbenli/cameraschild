package be.kdg.simulator.Messages;

import be.kdg.simulator.LicenseGenerators.RandomGenerator;
import be.kdg.simulator.Model.CameraMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.time.LocalDateTime;

@Component
public class QueueMessage implements MessageSender {
    private static final Logger LOG = LoggerFactory.getLogger(QueueMessage.class);
    private String cameraQueue="cameraQueue";
    private RabbitTemplate rabbitTemplate;

    public QueueMessage(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendMessage(CameraMessage cameraMessage){
        try {
            LOG.info("Message send to queue");
            JAXBContext context = JAXBContext.newInstance(CameraMessage.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter sw = new StringWriter();
            m.marshal(cameraMessage, sw);
            String cameraMessgeXml = sw.toString();
            System.out.println("Sent message to queue " + LocalDateTime.now());
            rabbitTemplate.convertAndSend(cameraQueue, cameraMessgeXml);
        } catch (Exception e) {
            System.out.println("Message is niet op queue gezet!" + e);
        }
    }
}

