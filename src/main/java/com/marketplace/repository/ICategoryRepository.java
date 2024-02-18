package com.marketplace.repository;

import com.marketplace.models.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(String name);

}
