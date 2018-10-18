package Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;
import java.util.Objects;

@XmlRootElement(name = "cameraMessage")
@XmlAccessorType(XmlAccessType.FIELD)
public class CameraMessage {
    @XmlElement
    private int id = 1;
    @XmlElement
    private int cameraId;
    @XmlElement
    private int frequency;
    @XmlElement
    private String licensePlate;
    @XmlElement
    private LocalDateTime localDateTime;

    public CameraMessage(int cameraId, int frequency, String licensePlate, LocalDateTime localDateTime) {
        this.cameraId = cameraId;
        this.frequency = frequency;
        this.licensePlate = licensePlate;
        this.localDateTime = localDateTime;
    }

    public CameraMessage(int cameraId, String licensePlate, LocalDateTime localDateTime) {
        this.cameraId = cameraId;
        this.frequency = 1000;
        this.licensePlate = licensePlate;
        this.localDateTime = localDateTime;
    }

    public int getCameraId() {
        return cameraId;
    }

    public int getFrequency() {
        return frequency;
    }

    public int getId() {
        return id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CameraMessage that = (CameraMessage) o;
        return id == that.id &&
                Objects.equals(licensePlate, that.licensePlate) &&
                Objects.equals(localDateTime, that.localDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, licensePlate, localDateTime);
    }

    @Override
    public String toString() {
        //TODO: datum formateren, volgendes dd-MM-yyyy HH:mm:ss:SSS
        return String.format("Camera Message %d %s %s", id++, licensePlate, localDateTime);
    }
}
