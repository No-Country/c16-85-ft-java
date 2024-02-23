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


    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.listReview();
    }


    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable Long reviewId) {
        return reviewService.buscarReviewPorId(reviewId);
    }


    @PostMapping
    public Review createReview(@RequestBody Review newReview) {
        return reviewService.guardarReview(newReview);
    }


    @PutMapping("/{id}")
    public Review updateReview(@PathVariable Long reviewId, @RequestBody Review updatedReview) {
        return reviewService.editarReviewPorID(reviewId, updatedReview);
    }



}