package com.marketplace.controller;

import com.marketplace.models.entity.Category;
import com.marketplace.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final ICategoryService categoryService;


    /** Obtener todas las categorías */
    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        return ResponseEntity.ok(categoryService.findAll());
    }

    /** Obtener categoría por ID */
    @GetMapping("/id/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        return new ResponseEntity<>(categoryService.findById(id), HttpStatus.OK);
    }

    /** Obtener categoría por nombre */
    @GetMapping("/name/{name}")
    public ResponseEntity<Category> findByName(@PathVariable String name){
        return new ResponseEntity<>(categoryService.findByName(name), HttpStatus.OK);
    }

    /** Guardar nueva categoría */
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Category category){
        categoryService.save(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /** Actualizar categoría */
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Category category){
        categoryService.update(id, category);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /** Eliminar definitivamente la categoría por ID */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
