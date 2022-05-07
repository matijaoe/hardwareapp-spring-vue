package hr.tvz.osrecki.hardwareapp.hardware.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HardwareDTO {

    private String code;

    private String name;

    private Double price;

}
