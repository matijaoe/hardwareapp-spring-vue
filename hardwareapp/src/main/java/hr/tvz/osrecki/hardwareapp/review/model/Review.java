package hr.tvz.osrecki.hardwareapp.review.model;

import hr.tvz.osrecki.hardwareapp.hardware.model.Hardware;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String text;

    private Integer rating;

    @ManyToOne(targetEntity = Hardware.class)
    private Hardware hardware;
}
