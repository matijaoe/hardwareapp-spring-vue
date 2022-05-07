package hr.tvz.osrecki.hardwareapp.review.repository;

import hr.tvz.osrecki.hardwareapp.review.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
