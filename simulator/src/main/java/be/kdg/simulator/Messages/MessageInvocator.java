package be.kdg.simulator.Messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class MessageInvocator {
    private MessageSender messageSender;
    private Environment env;
    private String printMessage;

    @Autowired
    public MessageInvocator(@Qualifier("commandLineMessage") CommandLineMessage commandLineMessage,
                            @Qualifier("queueMessage") QueueMessage queueMessage,
                            Environment env){
        this.env = env;
        printMessage = env.getProperty("messagePrint");
        if (printMessage.equalsIgnoreCase("cmd")){
            this.messageSender = commandLineMessage;
        }else if (printMessage.equalsIgnoreCase("queue")){
            this.messageSender = queueMessage;
        }
    }

    public MessageSender getMessageSender() {
        return messageSender;
    }
}
