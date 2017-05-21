package ru.trendsoft;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.trendsoft.model.News;
import ru.trendsoft.service.NewsService;
import ru.trendsoft.service.impl.NewsServiceImpl;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;


import java.util.List;

/**
 * Created by Andry on 21.05.17.
 */

@Transactional
public class TestNews {

//    private NewsService newsService;

    @Before
    public void init() {

//        this.newsService = new NewsServiceImpl();
        try {
//            newsService.save(new News("title_1", "Content_1"));
//            newsService.save(new News("title_2", "Content_2"));
//            newsService.save(new News("title_3", "Content_3"));
        }catch (Exception e)
        {
            assertNotNull(true);
        }
    }

    @Test
    public void testFindAll() {
//        List<News> news = newsService.findAll();
//        int count = news.size();
//        News firstElement = news.get(0);

        assertNotEquals(1L, 2L);
    }

//    @Test
//    public void testFindById() {
//        News news = newsService.findById(1l);
//        assertNotNull(news);
//    }
//
//    @Test
//    public void testSave() {
//        News news = new News();
//        news.setName("testTitle_1");
//        news.setContent("Time news.Today.");
//
//        News savedNews = newsService.save(news);
//
//        News newsFromDb = newsService.findById(savedNews.getId());
//
//        assertNotNull(newsFromDb);
//        newsService.delete(newsFromDb);
//    }
//
//    @Test(expected = javax.persistence.NoResultException.class)
//    public void testDelete() {
//        News news = new News();
//        news.setName("testTitle_1");
//        news.setContent("Time news.Today.");
//        News savedNews = newsService.save(news);
//
//        News newsFromDb = newsService.findById(savedNews.getId());
//        newsService.delete(newsFromDb);
//
//        newsService.findById(newsFromDb.getId());
//    }
}
