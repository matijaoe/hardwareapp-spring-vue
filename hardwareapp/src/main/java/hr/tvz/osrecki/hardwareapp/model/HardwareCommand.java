package hr.tvz.osrecki.hardwareapp.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Data
public class HardwareCommand {

    @NotBlank(message = "Name must not be empty")
    private String name;

    @NotBlank(message = "Code must not be empty")
    @Length(min = 4, max = 255, message = "Code must be between 4 and 255 characters long")
    private String code;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than 0")
    private Double price;

    @NotNull(message = "Type is required")
//    TODO: add enum validation
    private HardwareType type;

    @NotNull(message = "Available count is required")
    @PositiveOrZero(message = "Available count cannot be negative")
    private Integer availableCount;

}
