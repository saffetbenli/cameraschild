package Messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageInvocator {
    private MessageSender messageSender;

    @Autowired
    public MessageInvocator(@Qualifier("printCMD") CommandLineMessage commandLineMessage, @Qualifier("printQueue") QueueMessage queueMessage,@Value("$(messagePrint)") String printMessage) {
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
