package ru.trendsoft.test.controller;

import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.trendsoft.model.News;
import ru.trendsoft.service.NewsService;
import ru.trendsoft.test.TestConfig;

import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Andry on 26.05.17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { TestConfig.class } )
public class TestMainController {

    @Autowired
    private NewsService newsService;

    @Autowired
    WebApplicationContext wac;

    private MockMvc mockMvc;

    private Faker faker;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
        faker = new Faker();
    }

    @Test
    public void testIndex() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders
                .get("/news"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("newsList"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("categories"));

    }

    @Test
    public void testAddNews() throws Exception{
        List<News> newsList = newsService.findAll();
        // Databese is empty
        assertEquals(0, newsList.size());

        // Send request to add new News
        mockMvc.perform(MockMvcRequestBuilders.post("/news/add")
                .param("name", "News_1")
                .param("description", "Description_1")
                .param("content", "Content_1"))
                .andExpect(status().is3xxRedirection());


        // Check database is not empty
        List<News> newsListDB = newsService.findAll();
        assertEquals(1, newsListDB.size());
        assertNotNull(newsListDB.get(0));

        // Return database to start state
        newsService.delete(newsListDB.get(0));
    }

    @Test
    public void testDeleteNews() throws Exception{
        // add new News
        News news = createNews();
        newsService.save(news);

        // Check database is not empty
        List<News> newsList = newsService.findAll();
        assertEquals(1, newsList.size());

        mockMvc.perform(MockMvcRequestBuilders.get("/news/delete/" + newsList.get(0).getId()))
                .andExpect(status().is3xxRedirection());

        // Check database is empty
        List<News> newsListDB = newsService.findAll();
        assertEquals(0, newsListDB.size());
    }

    @Test
    public void testEditNews() throws Exception {

        News news = createNews();
        newsService.save(news);

        String content = "This is an updated post";

        mockMvc.perform(MockMvcRequestBuilders.post("/news/edit/" + news.getId())
                .param("name", news.getName())
                .param("description", news.getDescription())
                .param("content", content))
                .andExpect(status().is3xxRedirection());

        News newsDB = newsService.findById(news.getId());
        assertNotEquals(news.getContent(), newsDB.getContent());

        newsService.delete(news);
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
