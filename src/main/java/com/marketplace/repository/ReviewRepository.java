package com.marketplace.repository;

import com.marketplace.models.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
