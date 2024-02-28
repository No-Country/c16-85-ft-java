package com.marketplace.repository;

import com.marketplace.models.entity.ContractorProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractorProfileRepository extends JpaRepository<ContractorProfile, Long> {
}
