package ru.kpfu.itis.Mironov.SE.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Юра on 20.04.2016.
 */
@Controller
@RequestMapping("/{path:error404}")
public class Error404PageController {
    @Autowired
    private ModelAndView modelError404;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView error404DoGet(@ModelAttribute("model") ModelMap modelMap){
        return modelError404;
    }
}
