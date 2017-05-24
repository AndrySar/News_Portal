package ru.trendsoft.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public String test(Model uiModel){

        List<News> newsList = newsService.findAll();
        String[] arr = {"Cat1", "Cat2", "Cat3"};
        uiModel.addAttribute("news", newsList);
        uiModel.addAttribute("arrCat", toJavascriptArray(arr));

        return "addNews";
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
