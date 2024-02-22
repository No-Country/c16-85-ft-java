package com.marketplace.service.impl;

import com.marketplace.models.entity.Location;
import com.marketplace.models.entity.Review;
import com.marketplace.models.entity.ServicesHistory;
import com.marketplace.repository.ReviewRepository;
import com.marketplace.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewrepository;

    @Override
    public List<Review> listReview() {
        return reviewrepository.findAll();
    }

    @Override
    public Review buscarReviewPorId(Long id) {
        Optional<Review> optionalReview = reviewrepository.findById(id);
        return optionalReview.orElse(null);

    }

    @Override
    public Review guardarReview(Review newReview) {
        return reviewrepository.save(newReview);
    }

    @Override
    public Review editarReviewPorID(Long id, Review reviewUpDate) {
        Optional<Review> optionalReview = reviewrepository.findById(id);
        if (optionalReview.isPresent()) {
            Review reviewexistente = optionalReview.get();
            reviewexistente.setDescription(reviewUpDate.getDescription());
            return reviewrepository.save(reviewexistente);
        }
        return null;
    }
}
