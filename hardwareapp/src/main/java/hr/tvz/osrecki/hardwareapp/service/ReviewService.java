package hr.tvz.osrecki.hardwareapp.service;

import hr.tvz.osrecki.hardwareapp.model.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    List<Review> findAll();

    Optional<Review> findByTitle(String title);
}
