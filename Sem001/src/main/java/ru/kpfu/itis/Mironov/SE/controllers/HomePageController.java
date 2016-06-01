package ru.kpfu.itis.Mironov.SE.controllers;

/**
 * Created by Юра on 13.04.2016.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomePageController {
    @Autowired
    ModelAndView modelHome;
    @RequestMapping(value = "{path:home}", method = RequestMethod.GET)
    public ModelAndView homeDoGet(){
        return modelHome;
    }
}
