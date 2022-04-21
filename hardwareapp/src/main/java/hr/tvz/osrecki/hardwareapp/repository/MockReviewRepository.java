package hr.tvz.osrecki.hardwareapp.repository;

import hr.tvz.osrecki.hardwareapp.model.Rating;
import hr.tvz.osrecki.hardwareapp.model.Review;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MockReviewRepository implements ReviewRepository {

    private final Set<Review> MOCK_REVIEWS = new HashSet<>(Arrays.asList(
            new Review(Rating.THREE, "a", "This is a review for a"),
            new Review(Rating.FOUR, "b", "This is a review for b"),
            new Review(Rating.FIVE, "c", "This is a review for c")
    ));

    @Override
    public Set<Review> findAll() {
        return MOCK_REVIEWS;
    }

    @Override
    public Optional<Review> findByTitle(String title) {
        return MOCK_REVIEWS.stream().filter(item -> Objects.equals(item.getTitle(), title)).findAny();
    }

}
