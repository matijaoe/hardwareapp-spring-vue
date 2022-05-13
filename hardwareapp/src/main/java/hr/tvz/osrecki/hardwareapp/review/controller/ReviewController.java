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


    @GetMapping("/search")
    public List<ReviewDTO> searchReviewsByTitle(@RequestParam(value = "query", required = true) String query) {
        return reviewService.findByTitle(query);
    }

    @GetMapping("/details/{id}")
    public ReviewDTO getReviewById(@PathVariable Long id) {
        return reviewService.findDistinctById(id);
    }

    @GetMapping("{code}")
    public List<ReviewDTO> getReviewsForHardware(@PathVariable String code) {
        return reviewService.findByHardwareCode(code);
    }


}