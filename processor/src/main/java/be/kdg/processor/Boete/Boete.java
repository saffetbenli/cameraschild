package be.kdg.processor.Boete;

import be.kdg.processor.dom.CameraMessage;
import org.springframework.stereotype.Component;

@Component
public interface Boete {
    boolean findOut(CameraMessage cameraMessage);
}
