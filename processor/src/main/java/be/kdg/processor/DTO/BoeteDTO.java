package be.kdg.processor.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoeteDTO {
    @NotEmpty
    private Long id;
    @NotEmpty
    private String boeteType;
    @NotEmpty
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
