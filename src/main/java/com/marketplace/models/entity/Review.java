package com.marketplace.models.entity;

import com.marketplace.models.valueobjets.address.Address;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity(name = "reviews")
@ToString
@Setter
@Getter
@EqualsAndHashCode
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    private String description;

    private int score;

    @OneToOne
    private ServicesHistory servicesHistory;

    public Review() {}

    public Review(String description, int score, ServicesHistory servicesHistory) {
        this.description = description;
        this.score = score;
        this.servicesHistory = servicesHistory;
    }

    public static Review createReview(String description, int score, ServicesHistory servicesHistory) {
        return new Review(description, score, servicesHistory);
    }
}
