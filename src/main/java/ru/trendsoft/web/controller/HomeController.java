package ru.trendsoft.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Andry on 21.05.17.
 */

@RequestMapping(value = {"/"})
@Controller
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String test(){
        return "test";
    }

}
