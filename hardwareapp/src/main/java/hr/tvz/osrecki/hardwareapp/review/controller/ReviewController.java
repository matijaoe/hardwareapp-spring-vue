package hr.tvz.osrecki.hardwareapp.review.controller;

import hr.tvz.osrecki.hardwareapp.review.model.ReviewDTO;
import hr.tvz.osrecki.hardwareapp.review.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("reviews")
@CrossOrigin(origins = "*")
public class ReviewController {

    private final ReviewService reviewService;


    @GetMapping
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public List<ReviewDTO> getAllReviews() {
        return reviewService.findAll();
    }

    @GetMapping("{code}")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public List<ReviewDTO> getReviewsForHardware(@PathVariable String code) {
        return reviewService.findByHardwareCode(code);
    }

}
