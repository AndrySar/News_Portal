package ru.trendsoft.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.trendsoft.model.Category;
import ru.trendsoft.model.News;
import ru.trendsoft.service.CategoryService;
import ru.trendsoft.service.NewsService;

import java.util.Date;
import java.util.List;

/**
 * Created by Andry on 24.05.17.
 */

@RequestMapping(value = {"/news"})
@Controller
public class MainController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView list(){
        List<News> newsList = newsService.findAll();
        return new ModelAndView("index", "newsList", newsList);
    }

    @RequestMapping(value= {"/add"}, method = RequestMethod.GET)
    public ModelAndView addNews(){
        ModelAndView mav = new ModelAndView("addNews");
        mav.addObject("categories", categoryService.findAll());
        mav.addObject("newsObject", new News());

        return mav;
    }

    @RequestMapping(value= {"/add"}, method = RequestMethod.POST)
    public ModelAndView createNews(@ModelAttribute("newsObject") News newsObject){

        String message = "Error create new News!";
        if(newsObject != null){
            newsObject.setDate(new Date());
            newsService.save(newsObject);
            message = String.format("Successfullу : News %s is added!", newsObject.getName());
        }

        return new ModelAndView("redirect:/", "message", message);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.DELETE)
    public ModelAndView deleteNews(@PathVariable("id") Long id) {
        String message = "Error delete News";

        News news = newsService.findById(id);
        if(news != null) {
            newsService.delete(news);
            message = String.format("Successfullу : News %s is deleted!", news.getName());
        }
        return new ModelAndView("redirect:/", "message", message);
    }

    @RequestMapping(value = {"/edit/{id}"}, method = RequestMethod.GET)
    public ModelAndView editNews(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("editNews");
        mav.addObject("newObject", newsService.findById(id));
        mav.addObject("categories", categoryService.findAll());

        return mav;
    }

    @RequestMapping(value = {"/edit"}, method = RequestMethod.POST)
    public ModelAndView updateNews(@ModelAttribute("newsObject") News newsObject) {
        String message = "Error delete News";

        if(newsObject != null) {
            newsObject.setDate(new Date());
            newsService.update(newsObject);
            message = "Successfullу : News is update!";
        }

        return new ModelAndView("redirect:/", "message", message);
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
