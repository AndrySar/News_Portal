package ru.trendsoft.service;

import ru.trendsoft.model.Category;

import java.util.List;

/**
 * Created by Andry on 24.05.17.
 */
public interface CategoryService {
    public List<Category> findAll();
    public Category findById(Long id);
    public Category save(Category category);
    public void delete(Category category);
}
