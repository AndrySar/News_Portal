package ru.trendsoft.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.trendsoft.model.News;
import ru.trendsoft.service.NewsService;

import java.util.List;

/**
 * Created by Andry on 21.05.17.
 */

@RequestMapping(value = {"/"})
@Controller
public class HomeController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView test(Model uiModel){
        return new ModelAndView("redirect:/news");
    }
}
