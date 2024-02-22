package com.marketplace.repository;

import com.marketplace.models.entity.ContractorProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractorProfileRepository extends JpaRepository<ContractorProfile, Long> {
}
