package Messages;

import Model.CameraMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import rabbitmq.RabbitConfig;

@Component
public class QueueMessage implements MessageSender {
    private String cameraQueue;
    private RabbitTemplate rabbitTemplate;

    public QueueMessage(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendMessage(CameraMessage cameraMessage) {
        try {
            while(true){
                rabbitTemplate.convertAndSend(RabbitConfig.getTopicExchangeName(), "licence", cameraMessage);
            }
        } catch (Exception e) {
            System.out.println("Error marshalling file be.kdg.processor.message to XML." + e);
        }
    }
}
