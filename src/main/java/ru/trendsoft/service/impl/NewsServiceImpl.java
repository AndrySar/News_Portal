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

    @Transactional(readOnly = true)
    public List<News> findAll() {
        return em.createNamedQuery("News.findAll", News.class).getResultList();
    }

    @Transactional(readOnly = true)
    public News findById(Long id) {
        TypedQuery<News> query = em.createNamedQuery("News.findById", News.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Transactional(readOnly = false)
    public News save(News news) {
        if (news != null && news.getId() == null) {
//            log.info("Inserting new provider");
            em.persist(news);
        } else {
            em.merge(news);
//            log.info("Updating existing provider");
        }
//        log.info("Provider saved with id: " + provider.getId());
        return news;
    }

    @Transactional(readOnly = false)
    public void delete(News news) {
        News mergedNews = em.merge(news);
        em.remove(mergedNews);
//        log.info("Provider with id: " + provider.getId() + " deleted successfully");
    }
}
