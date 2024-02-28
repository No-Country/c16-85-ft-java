package com.marketplace.repository;

import com.marketplace.models.entity.ServicesHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ServicesHistoriRepository extends JpaRepository<ServicesHistory, Long> {
}
