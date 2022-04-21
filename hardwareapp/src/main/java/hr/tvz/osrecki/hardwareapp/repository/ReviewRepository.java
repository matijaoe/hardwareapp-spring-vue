package hr.tvz.osrecki.hardwareapp.repository;

import hr.tvz.osrecki.hardwareapp.model.Review;

import java.util.Optional;
import java.util.Set;

public interface ReviewRepository {


    Set<Review> findAll();

    Optional<Review> findByTitle(String title);
}
