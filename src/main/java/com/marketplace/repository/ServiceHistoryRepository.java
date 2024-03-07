package com.marketplace.repository;

import com.marketplace.models.entity.ServicesHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceHistoryRepository extends JpaRepository<ServicesHistory,Long> {

    void deleteById(Long id);

}
