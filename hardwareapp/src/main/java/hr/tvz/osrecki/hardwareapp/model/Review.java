package hr.tvz.osrecki.hardwareapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Review {

    private Rating rating;
    private String title;
    private String description;
}
