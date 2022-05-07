package hr.tvz.osrecki.hardwareapp.review.controller;

import hr.tvz.osrecki.hardwareapp.review.model.ReviewDTO;
import hr.tvz.osrecki.hardwareapp.review.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("reviews")
@CrossOrigin(origins = "*")
public class ReviewController {

    private final ReviewService reviewService;


    @GetMapping
    public List<ReviewDTO> getAllReviews() {
        return reviewService.findAll();
    }

    @GetMapping("{code}")
    public List<ReviewDTO> getReviewsForHardware(@PathVariable String code) {
        return reviewService.findByHardwareCode(code);
    }

}
