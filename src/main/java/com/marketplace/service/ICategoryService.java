package com.marketplace.service;

import com.marketplace.models.entity.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();

    Category findById(Long id);

    Category findByName(String name);

    void save(Category category);

    void update(Long id, Category category);

    void delete(Long id);

}
