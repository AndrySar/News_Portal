package ru.trendsoft.test.service;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ru.trendsoft.model.News;
import ru.trendsoft.service.CategoryService;
import ru.trendsoft.service.NewsService;
import ru.trendsoft.test.TestConfig;

import java.util.Date;
import java.util.List;

/**
 * Created by Andry on 25.05.17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { TestConfig.class } )
@Transactional
public class TestNewsService {

    @Autowired
    private NewsService newsService;

    @Autowired
    private CategoryService categoryService;

    private Faker faker;

    @Before
    public void init() {

        faker = new Faker();

        try {
            News news1 = createNews();
            newsService.save(news1);

            News news2 = createNews();
            newsService.save(news2);

        }catch (Exception e)
        {
            assertNotNull(true);
        }
    }

    @Test
    @Transactional
    public void testFindAll() {
        List<News> news = newsService.findAll();
        assertNotNull(news);
        assertEquals(2, news.size());
    }

    @Test
    @Transactional
    public void testFindById() {
        List<News> news = newsService.findAll();
        News newsOne = newsService.findById(news.get(0).getId());
        assertNotNull(newsOne);
        assertEquals(news.get(0).getId(), newsOne.getId());
    }

    @Test
    @Transactional
    public void testInsertNews_1() {
        News news = createNews();
        newsService.save(news);

        News dbNews = newsService.findById(news.getId());
        assertNotNull(dbNews);
        assertEquals(news.getDescription(), dbNews.getDescription());
        assertEquals(news.getContent(), dbNews.getContent());

        newsService.delete(dbNews);
    }

    @Test
    @Transactional
    public void testUpdateNews() {
        String content = "This is an updated post";

        List<News> newsList = newsService.findAll();
        News news = newsService.findById(newsList.get(0).getId());
        assertNotNull(news);
        news.setContent(content);
        newsService.save(news);

        News dbNews = newsService.findById(news.getId());
        assertNotNull(dbNews);
        assertEquals(content, dbNews.getContent());
    }

    @Test
    @Transactional
    public void testDeleteNews() {
        List<News> newsList = newsService.findAll();
        News news = newsService.findById(newsList.get(0).getId());
        newsService.delete(news);

        News dbNews = newsService.findById(news.getId());
        assertNull(dbNews);
    }

    private News createNews(){
        News news = new News();
        news.setName(faker.sentence());
        news.setDescription(faker.sentence());
        news.setContent(faker.sentence());
        news.setDate(new Date());
        return news;
    }
}

