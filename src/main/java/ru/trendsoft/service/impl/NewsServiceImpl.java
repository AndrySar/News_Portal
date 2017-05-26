package ru.trendsoft.service.impl;

import org.apache.log4j.Logger;
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

    private Logger logger = Logger.getLogger(NewsServiceImpl.class);

    @Transactional(readOnly = true)
    public List<News> findAll() {
        return em.createNamedQuery("News.findAll", News.class).getResultList();
    }

    @Transactional(readOnly = true)
    public News findById(Long id) {
        TypedQuery<News> query = em.createNamedQuery("News.findById", News.class);
        query.setParameter("id", id);
        List<News> list = query.getResultList();
        if(!list.isEmpty()){
           return list.get(0);
        }
        return null;
    }

    @Transactional(readOnly = false)
    public News save(News news) {
        if (news.getId() == null) {
            logger.info("Inserting new News");
            em.persist(news);
        } else {
            em.merge(news);
            logger.info("Updating existing News");
        }
        logger.info("News saved with id: " + news.getId());
        return news;
    }

    @Transactional(readOnly = false)
    public void delete(News news) {
        News mergedNews = em.merge(news);
        em.remove(mergedNews);
        logger.info("Provider with id: " + mergedNews.getId() + " deleted successfully");
    }

    @Transactional(readOnly = true)
    public List<News> findByTitleContent(String search) {
        TypedQuery<News> query = em.createNamedQuery("News.findByTitleAndContent", News.class);
        query.setParameter("search", "%"+search+"%");
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    public List<News> findByCategoryId(Long id) {
        TypedQuery<News> query = em.createNamedQuery("News.findByCategoryId", News.class);
        query.setParameter("categoryId", id );
        return query.getResultList();
    }
}
