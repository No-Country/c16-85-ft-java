package com.marketplace.models.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "reviews")
@ToString
@Setter
@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    private String description;
    private int score;
    @OneToMany(mappedBy = "review")
    private List<ServicesHistory> servicesHistoryList;
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
