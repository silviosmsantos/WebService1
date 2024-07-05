package com.santos.webservice.service;

import com.santos.webservice.entities.Category;
import com.santos.webservice.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findByID(Long id){
        Optional<Category> OptionalCategory = categoryRepository.findById(id);
        return OptionalCategory.get();
    }
}
