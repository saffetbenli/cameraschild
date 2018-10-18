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
    private int id;
    @NotEmpty
    private String boeteType;
    @NotEmpty
    private String bestuurder;
}
