package hr.tvz.osrecki.hardwareapp.model;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Hardware {

    private Long id;

    @EqualsAndHashCode.Include()
    private String code;

    private String name;

    private Double price;

    private HardwareType type;

    private Integer availableCount;
}
