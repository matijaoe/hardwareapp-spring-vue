package hr.tvz.osrecki.hardwareapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Hardware {
    private String name;
    private String code;
    private Double price;
    private HardwareType type;
    private Integer availableCount;
}
