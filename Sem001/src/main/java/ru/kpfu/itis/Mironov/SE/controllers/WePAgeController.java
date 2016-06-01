package ru.kpfu.itis.Mironov.SE.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Юра on 19.04.2016.
 */
@Controller
@RequestMapping("/{path:we}")
public class WePageController {
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView weDoGet(){
        return new ModelAndView("We");
    }
}
