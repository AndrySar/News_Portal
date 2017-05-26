package ru.trendsoft.web.controller;

import com.sun.javafx.sg.prism.NGShape;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.trendsoft.model.Category;
import ru.trendsoft.model.News;
import ru.trendsoft.service.CategoryService;
import ru.trendsoft.service.NewsService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Andry on 24.05.17.
 */

@RequestMapping(value = {"/news"})
@Controller
public class MainController {

    private Logger logger = Logger.getLogger(MainController.class);

    private NewsService newsService;

    private CategoryService categoryService;

    List<Category> categoryList = new ArrayList<>();

    @Autowired
    public MainController(NewsService _newsService, CategoryService _categoryService){
        newsService = _newsService;
        categoryService = _categoryService;
        categoryList.addAll(categoryService.findAll());
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView list(@RequestParam( value = "search", required = false) String search, @RequestParam( value = "caregoryId", required = false) Long id){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("categories", categoryList);

        if(search != null && !search.isEmpty()) {
            mav.addObject("newsList", newsService.findByTitleContent(search));
        }else if(id != null) {
            mav.addObject("newsList", newsService.findByCategoryId(id));
            mav.addObject("headTitle", categoryService.findById(id));

        }else {
            mav.addObject("newsList", newsService.findAll());
        }

        return mav;
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public ModelAndView singleNews(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("singleNews");
        mav.addObject("categories", categoryList);

        News news = newsService.findById(id);

        if( news != null)
            mav.addObject("news", news);

        return mav;
    }

    @RequestMapping(value= {"/add"}, method = RequestMethod.GET)
    public ModelAndView addNews(){
        ModelAndView mav = new ModelAndView("addNews");
        mav.addObject("newsObject", new News());
        mav.addObject("categories", categoryList);

        return mav;
    }

    @RequestMapping(value= {"/add"}, method = RequestMethod.POST)
    public ModelAndView createNews(@ModelAttribute("newsObject") News news, Model model){

        String message = "Error: do not create new News!";
        if(news != null){
            news.setDate(new Date());
            newsService.save(news);
            message = String.format("Successfullу: news '%s' is added!", news.getName());
            logger.info(message);
        }else {
            logger.error(message);
        }


        return new ModelAndView("redirect:/news", "message", message);
    }

    @RequestMapping(value = {"/delete/{id}"}, method = RequestMethod.GET)
    public ModelAndView deleteNews(@PathVariable("id") Long id) {
        String message = "Error: do not delete news!";

        News news = newsService.findById(id);
        if(news != null) {
            newsService.delete(news);
            message = String.format("Successfullу : news '%s' is deleted!", news.getName());
            logger.info(message);
        }else {
            logger.error(String.format("{0}, Entity id = {1}", message, id));
        }

        ModelAndView mav = new ModelAndView("redirect:/news");
        mav.addObject("message", message);

        return mav;
    }

    @RequestMapping(value = {"/edit/{id}"}, method = RequestMethod.GET)
    public ModelAndView editNews(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("editNews");
        mav.addObject("newsObject", newsService.findById(id));
        mav.addObject("categories", categoryService.findAll());

        return mav;
    }

    @RequestMapping(value = {"/edit/{id}"}, method = RequestMethod.POST)
    public ModelAndView updateNews(@PathVariable("id") Long id, @ModelAttribute("newsObject") News newsObject) {
        String message = "Error: do not update News!";

        if(newsObject != null) {
            newsObject.setId(id);
            System.out.println(newsObject.toString());
            newsObject.setDate(new Date());
            newsService.save(newsObject);
            message = "Successfullу : News is update!";
            logger.info(message);
        }else {
            logger.error(String.format("{0}, Entity id = {1}", message, id));
        }

        return new ModelAndView("redirect:/news", "message", message);
    }


    @InitBinder
    protected void initBinder(WebDataBinder binder) throws Exception {
        binder.registerCustomEditor(Set.class, "categorys", new CustomCollectionEditor(Set.class) {
            protected Object convertElement(Object element) {
                if (element instanceof Category) {
                    logger.info("Converting from Category to Category: " + element);
                    return element;
                }
                if (element instanceof String) {
                    Category cater = categoryService.findById(Long.parseLong(element.toString()));
                    logger.info("Looking up category for id " + element + ": " + cater);
                    return cater;
                }
                logger.info("Don't know what to do with: " + element);
                return null;
            }
        });
    }


    public String toJavascriptArray(String[] arr){
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for(int i=0; i<arr.length; i++){
            sb.append("\"").append(arr[i]).append("\"");
            if(i+1 < arr.length){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
