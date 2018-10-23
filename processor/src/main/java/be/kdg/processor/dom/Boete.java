package be.kdg.processor.dom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Boete {
    private Long id;
    private String boeteType;
    private String bestuurder;


    public Long getId() {
        return id;
    }

    public String getBoeteType() {
        return boeteType;
    }

    public String getBestuurder() {
        return bestuurder;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBoeteType(String boeteType) {
        this.boeteType = boeteType;
    }

    public void setBestuurder(String bestuurder) {
        this.bestuurder = bestuurder;
    }
}
