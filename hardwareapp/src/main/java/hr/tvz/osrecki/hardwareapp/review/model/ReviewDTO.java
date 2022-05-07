package hr.tvz.osrecki.hardwareapp.review.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewDTO {

    private Long id;

    private String title;

    private String text;

    private Integer rating;
}
