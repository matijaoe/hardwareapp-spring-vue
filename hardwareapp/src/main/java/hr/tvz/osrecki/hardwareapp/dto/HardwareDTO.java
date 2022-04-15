package hr.tvz.osrecki.hardwareapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HardwareDTO {
    private String name;
    private Double price;
    private String code;
}
