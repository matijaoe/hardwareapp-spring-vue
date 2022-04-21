package hr.tvz.osrecki.hardwareapp.controller;

import hr.tvz.osrecki.hardwareapp.model.Review;
import hr.tvz.osrecki.hardwareapp.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("reviews")
@CrossOrigin(origins = "*")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public List<Review> getAllHardware() {
        return reviewService.findAll();
    }

    @GetMapping("/{title}")
    public ResponseEntity<Review> getHardware(@PathVariable String title) {
        return reviewService
                .findByTitle(title)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
