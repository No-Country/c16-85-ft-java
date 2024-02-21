package com.marketplace.service;

import com.marketplace.models.entity.Location;
import com.marketplace.models.entity.Review;

import java.util.List;
import java.util.UUID;

public interface ReviewService {
    List<Review> listReview();

    Review buscarReviewPorId(UUID id);


    Review guardarReview(Review newReview);

    Review editarReviewPorID (UUID id, Review reviewUpDate);


}
