package com.marketplace.repository;

import com.marketplace.models.entity.ServicesHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ServicesHistoriRepository extends JpaRepository<ServicesHistory, UUID> {
}
