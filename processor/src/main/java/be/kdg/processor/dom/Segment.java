package be.kdg.processor.dom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Segment {
    private int connectedCameraId;
    private int distance;
    private int speedLimit;
}
