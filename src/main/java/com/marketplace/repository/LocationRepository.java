package com.marketplace.repository;

import com.marketplace.models.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LocationRepository extends JpaRepository<Location, Long>{

}
