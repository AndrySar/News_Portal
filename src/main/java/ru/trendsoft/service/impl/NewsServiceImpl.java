package ru.trendsoft.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.trendsoft.model.News;
import ru.trendsoft.service.NewsService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Andry on 21.05.17.
 */

@Service("newsService")
@Transactional
public class NewsServiceImpl implements NewsService{

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public List<News> findAll() {
        return em.createNamedQuery("News.findAll", News.class).getResultList();
    }

    @Transactional
    public News findById(Long id) {
        TypedQuery<News> query = em.createNamedQuery("News.findById", News.class);
        query.setParameter("id", id);
        List<News> list = query.getResultList();
        if(!list.isEmpty()){
           return list.get(0);
        }
        return null;
    }

    @Transactional
    public News save(News news) {
        if (news.getId() == null) {
//            log.info("Inserting new provider");
            em.persist(news);
        } else {
            em.merge(news);
//            log.info("Updating existing provider");
        }
//        log.info("Provider saved with id: " + provider.getId());
        return news;
    }

    @Transactional
    public void delete(News news) {
        News mergedNews = em.merge(news);
        em.remove(mergedNews);
//        log.info("Provider with id: " + provider.getId() + " deleted successfully");
    }

    @Transactional
    public void update(News news) {
//        TypedQuery<News> query = em.createNamedQuery("News.update", News.class);
//        query.setParameter("id", news.getId());
//        query.setParameter("name", news.getName());
//        query.setParameter("description", news.getDescription());
//        query.setParameter("content", news.getContent());
//        query.setParameter("date", news.getDate());
//        query.executeUpdate();
    }
}
