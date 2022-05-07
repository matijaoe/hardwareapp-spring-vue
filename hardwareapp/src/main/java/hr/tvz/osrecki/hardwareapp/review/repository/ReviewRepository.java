package hr.tvz.osrecki.hardwareapp.review.repository;

import hr.tvz.osrecki.hardwareapp.review.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findReviewsBy();

    List<Review> findAllByHardware_Code(String code);
}
