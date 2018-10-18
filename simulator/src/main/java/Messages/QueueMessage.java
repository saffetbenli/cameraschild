package Messages;

import Model.CameraMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import rabbitmq.RabbitConfig;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.time.LocalDateTime;

@Component
public class QueueMessage implements MessageSender {
    private String cameraQueue;
    private RabbitTemplate rabbitTemplate;

    public QueueMessage(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendMessage(CameraMessage cameraMessage) throws JAXBException {
        try {
            JAXBContext context = JAXBContext.newInstance(CameraMessage.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter sw = new StringWriter();
            m.marshal(cameraMessage, sw);
            String cameraMessgeXml = sw.toString();
            System.out.println("Sent message to queue " + LocalDateTime.now());
            rabbitTemplate.convertAndSend(RabbitConfig.getTopicExchangeName(), "licence", cameraMessage);
        } catch (Exception e) {
            System.out.println("Message is niet op queue gezet!" + e);
        }
    }
}

