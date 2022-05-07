package hr.tvz.osrecki.hardwareapp.hardware.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Hardware {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String name;

    private Double price;

    @Enumerated(EnumType.STRING)
    private HardwareType type;

    private Integer quantity;
}
