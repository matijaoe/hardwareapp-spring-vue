package hr.tvz.osrecki.hardwareapp.review.service;

import hr.tvz.osrecki.hardwareapp.review.model.ReviewDTO;

import java.util.List;

public interface ReviewService {

    List<ReviewDTO> findAll();

    List<ReviewDTO> findByHardwareCode(String code);
}
