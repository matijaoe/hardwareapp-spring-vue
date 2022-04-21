package hr.tvz.osrecki.hardwareapp.service;

import hr.tvz.osrecki.hardwareapp.model.Review;
import hr.tvz.osrecki.hardwareapp.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public List<Review> findAll() {
        return new ArrayList<>(reviewRepository.findAll());
    }

    @Override
    public Optional<Review> findByTitle(String title) {
        return reviewRepository.findByTitle(title);
    }
}
