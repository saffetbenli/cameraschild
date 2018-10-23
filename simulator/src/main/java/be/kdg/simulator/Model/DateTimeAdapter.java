package be.kdg.simulator.Model;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeAdapter extends XmlAdapter<String,LocalDateTime> {
    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSS");

    @Override
    public String marshal(LocalDateTime v) {
        return dateFormat.format(v);
    }

    @Override
    public LocalDateTime unmarshal(String v) {
        synchronized (dateFormat) {
            return (LocalDateTime) dateFormat.parse(v);
        }
    }
}
