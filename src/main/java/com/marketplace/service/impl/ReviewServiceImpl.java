package com.marketplace.service.impl;

import com.marketplace.models.entity.Location;
import com.marketplace.models.entity.Review;
import com.marketplace.models.entity.ServicesHistory;
import com.marketplace.repository.ReviewRepository;
import com.marketplace.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository repository;

    @Override
    public List<Review> listReview() {
        return repository.findAll();
    }

    @Override
    public Review buscarReviewPorId(Long reviewId) {
        return repository.findById(reviewId)
                .orElseThrow();
    }

    @Override
    public Review guardarReview(Review newReview) {
        return repository.save(newReview);
    }
}
