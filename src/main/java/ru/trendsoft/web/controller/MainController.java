package ru.trendsoft.web.controller;

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

import java.util.Date;
import java.util.List;
import java.util.Set;

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

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public ModelAndView singleNews(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("singleNews");
        News news = newsService.findById(id);

        if( news != null)
            mav.addObject("news", news);

        return mav;
    }

    @RequestMapping(value= {"/add"}, method = RequestMethod.GET)
    public ModelAndView addNews(){
        ModelAndView mav = new ModelAndView("addNews");
        mav.addObject("newsObject", new News());
        mav.addObject("categories", categoryService.findAll());

        return mav;
    }

    @RequestMapping(value= {"/add"}, method = RequestMethod.POST)
    public ModelAndView createNews(@ModelAttribute("newsObject") News news, Model model){

        String message = "Error create new News!";
        if(news != null){
            System.out.println(news.toString());

           Set<Category> cat = news.getCategorys();

            for(Category i : cat) {
                System.out.println(i.toString());
            }

            news.setDate(new Date());
            newsService.save(news);
            message = String.format("Successfullу : News %s is added!", news.getName());
        }

        return new ModelAndView("redirect:/news", "message", message);
    }

    @RequestMapping(value = {"/delete/{id}"}, method = RequestMethod.GET)
    public ModelAndView deleteNews(@PathVariable("id") Long id) {
        String message = "Error delete News";

        News news = newsService.findById(id);
        if(news != null) {
            newsService.delete(news);
            message = String.format("Successfullу : News %s is deleted!", news.getName());
        }

        ModelAndView mav = new ModelAndView("redirect:/news");
        mav.addObject("message", message);

        return mav;
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


    @InitBinder
    protected void initBinder(WebDataBinder binder) throws Exception {
        binder.registerCustomEditor(Set.class, "categorys", new CustomCollectionEditor(Set.class) {
            protected Object convertElement(Object element) {
                if (element instanceof Category) {
                    System.out.println("Converting from Staff to Staff: " + element);
                    return element;
                }
                if (element instanceof String) {
                    Category cater = categoryService.findById(Long.parseLong(element.toString()));
                    System.out.println("Looking up staff for id " + element + ": " + cater);
                    return cater;
                }
                System.out.println("Don't know what to do with: " + element);
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
