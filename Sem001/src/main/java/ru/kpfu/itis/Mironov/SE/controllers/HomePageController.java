package ru.kpfu.itis.Mironov.SE.controllers;

/**
 * Created by Юра on 13.04.2016.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomePageController {
    @RequestMapping(value = "{path:home}", method = RequestMethod.GET)
    public String homeDoGet(@ModelAttribute("model") ModelMap model){
        return "Home";
    }
}
