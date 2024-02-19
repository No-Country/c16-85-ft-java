package com.marketplace.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Entity(name = "ContractorProfiles")
@ToString
@EqualsAndHashCode
@Getter
public class ContractorProfile {

    @Id
    @GeneratedValue
    private Long id;
}
