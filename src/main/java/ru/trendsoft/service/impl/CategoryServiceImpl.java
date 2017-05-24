package ru.trendsoft.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.trendsoft.model.Category;
import ru.trendsoft.service.CategoryService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Andry on 24.05.17.
 */

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public List<Category> findAll() {
        return em.createNamedQuery("Category.findAll", Category.class).getResultList();
    }

    @Transactional(readOnly = true)
    public Category findById(Long id) {
        TypedQuery<Category> query = em.createNamedQuery("Category.findById", Category.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Transactional(readOnly = false)
    public Category save(Category category) {
        if (category != null && category.getId() == null) {
            em.persist(category);
        } else {
            em.merge(category);
        }
        return category;
    }

    @Transactional(readOnly = false)
    public void delete(Category category) {
        Category mergedCategory = em.merge(category);
        em.remove(mergedCategory);
    }
}
