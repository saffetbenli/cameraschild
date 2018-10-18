package be.kdg.processor.dom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Camera {
    private int cameraId;
    private Location location;
    private Segment segment;
    private int euro;
}
