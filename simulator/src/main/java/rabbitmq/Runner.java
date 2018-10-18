package rabbitmq;

import LicenseGenerators.RandomGenerator;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;
    private RandomGenerator random = new RandomGenerator();

    public Runner(Receiver receiver, RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sending licences...");
        while(true){
            rabbitTemplate.convertAndSend(RabbitConfig.topicExchangeName, "licence", "TEST");
        }
    }
}