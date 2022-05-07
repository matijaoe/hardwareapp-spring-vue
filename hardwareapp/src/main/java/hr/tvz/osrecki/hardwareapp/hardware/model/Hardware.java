package hr.tvz.osrecki.hardwareapp.hardware.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
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

    public Hardware(Long id, String code, String name, Double price, HardwareType type, Integer quantity) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = quantity;
    }

    public Hardware(String code, String name, Double price, HardwareType type, Integer quantity) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = quantity;
    }
}
