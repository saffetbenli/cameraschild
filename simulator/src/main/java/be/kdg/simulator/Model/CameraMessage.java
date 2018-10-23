package be.kdg.simulator.Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.util.Objects;

@XmlRootElement(name = "cameraMessage")
@XmlAccessorType(XmlAccessType.FIELD)
public class CameraMessage {
    @XmlElement
    private int cameraId;
    @XmlElement
    private String licensePlate;
    @XmlElement
    @XmlJavaTypeAdapter(DateTimeAdapter.class)
    private LocalDateTime localDateTime;

    public CameraMessage(int cameraId, String licensePlate, LocalDateTime localDateTime) {
        this.cameraId = cameraId;
        this.licensePlate = licensePlate;
        this.localDateTime = localDateTime;
    }

    public CameraMessage() {
    }

    public int getCameraId() {
        return cameraId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public LocalDateTime getTimestamp() {
        return localDateTime;
    }

    public void setTimestamp(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CameraMessage that = (CameraMessage) o;
        return cameraId == that.cameraId &&
                Objects.equals(licensePlate, that.licensePlate) &&
                Objects.equals(localDateTime, that.localDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cameraId, licensePlate, localDateTime);
    }

    @Override
    public String toString() {
        return String.format("CameraMessage %d %s %s", cameraId, licensePlate, localDateTime);
    }
}
