package com.marketplace.controller;


import com.marketplace.models.entity.Review;
import com.marketplace.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    /*Este controlador trae toda la lista de la entidad Review */
    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.listReview();
    }

    /*Este controlador trae un elemento por su Id de la lista de la entidad Review */
    @GetMapping("buscar/{id}")
    public Review getReviewById(@PathVariable Long reviewId) {
        return reviewService.buscarReviewPorId(reviewId);
    }

    /*Este controlador envia datos ala entidad Review */
    @PostMapping("/send")
    public Review createReview(@RequestBody Review newReview) {
        return reviewService.guardarReview(newReview);
    }

    /*Este controlador actualiza un dato por Id de la entidad Review */
    @PutMapping("update/{id}")
    public Review updateReview(@PathVariable Long reviewId, @RequestBody Review updatedReview) {
        return reviewService.editarReviewPorID(reviewId, updatedReview);
    }



}