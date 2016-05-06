package ru.kpfu.itis.Mironov.SE.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Юра on 20.04.2016.
 */
@Controller
@RequestMapping("/{path:error404}")
public class Error404PageController {
    @RequestMapping(method = RequestMethod.GET)
    public String error404DoGet(@ModelAttribute("model") ModelMap modelMap){
        return "error404";
    }
}
