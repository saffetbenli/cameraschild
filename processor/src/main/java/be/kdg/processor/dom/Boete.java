package be.kdg.processor.dom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Boete {
    private int id;
    private String boeteType;
    private String bestuurder;
}
