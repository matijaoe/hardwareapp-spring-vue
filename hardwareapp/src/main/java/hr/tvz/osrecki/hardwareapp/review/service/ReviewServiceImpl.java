package hr.tvz.osrecki.hardwareapp.review.service;

import hr.tvz.osrecki.hardwareapp.review.model.Review;
import hr.tvz.osrecki.hardwareapp.review.model.ReviewDTO;
import hr.tvz.osrecki.hardwareapp.review.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public List<ReviewDTO> findAll() {
        return reviewRepository.findReviewsBy().stream().map(this::mapReviewToDTO).collect(Collectors.toList());
    }

    @Override
    public List<ReviewDTO> findByHardwareCode(String code) {
        return reviewRepository.findAllByHardware_Code(code).stream().map(this::mapReviewToDTO).collect(Collectors.toList());
    }

    private ReviewDTO mapReviewToDTO(final Review review) {
        return new ReviewDTO(review.getId(), review.getTitle(), review.getText(), review.getRating());
    }
}
