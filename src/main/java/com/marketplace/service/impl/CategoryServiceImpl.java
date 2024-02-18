package com.marketplace.service.impl;

import com.marketplace.exceptions.CategoryNotFoundException;
import com.marketplace.exceptions.CategoryRepeatedException;
import com.marketplace.models.entity.Category;
import com.marketplace.repository.ICategoryRepository;
import com.marketplace.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {

    static String CATEGORY_NOT_FOUND = "La categoría no existe";
    static String CATEGORY_REPEATED = "Ya existe esa categoría";

    // --------------------------------

    private final ICategoryRepository categoryRepository;


    // --------------------------------

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(()-> new CategoryNotFoundException(CATEGORY_NOT_FOUND));
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name)
                .orElseThrow(()-> new CategoryNotFoundException(CATEGORY_NOT_FOUND));
    }

    @Override
    public void save(Category category) {
        // Verificar si la categoría existe
        Optional<Category> categoryDB = categoryRepository.findByName(category.getName());

        if (categoryDB.isPresent())
            throw new CategoryRepeatedException(CATEGORY_REPEATED);

        // Guardar categoría
        categoryRepository.save(category);
    }

    @Override
    public void update(Long id, Category category) {
        // Verificar si la categoría existe
        Optional<Category> categoryDB = categoryRepository.findByName(category.getName());

        // Verificar si otra categoría tiene el mismo nombre
        if (categoryDB.isPresent() && !id.equals(categoryDB.get().getId()))
            throw new CategoryRepeatedException(CATEGORY_REPEATED);

        // Guardar categoría actualizada
        category.setId(id);
        categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        categoryRepository.deleteById(id);
    }
}
