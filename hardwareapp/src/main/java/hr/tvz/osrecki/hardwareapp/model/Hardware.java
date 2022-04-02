package hr.tvz.osrecki.hardwareapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Hardware {
    private String name;

    @EqualsAndHashCode.Include()
    private String code;

    private Double price;

    private HardwareType type;

    private Integer availableCount;
}
