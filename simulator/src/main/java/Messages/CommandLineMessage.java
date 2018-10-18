package Messages;

import Model.CameraMessage;

public class CommandLineMessage implements MessageSender {
    @Override
    public void sendMessage(CameraMessage cameraMessage) {
        System.out.println(cameraMessage);
    }
}
