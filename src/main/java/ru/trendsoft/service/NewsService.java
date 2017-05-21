package ru.trendsoft.service;

import ru.trendsoft.model.News;

import java.util.List;

/**
 * Created by Andry on 21.05.17.
 */

public interface NewsService {
    public List<News> findAll();
    public News findById(Long id);
    public News save(News news);
    public void delete(News news);
}
