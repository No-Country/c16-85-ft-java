package com.marketplace.repository;

import com.marketplace.models.entity.ServicesHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicesHistoryRepository extends JpaRepository<ServicesHistory, Long> {
}
