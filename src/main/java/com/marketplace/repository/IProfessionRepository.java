package com.marketplace.repository;

import com.marketplace.models.entity.ProfessionalService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IProfessionRepository extends JpaRepository<ProfessionalService, UUID> {

}
