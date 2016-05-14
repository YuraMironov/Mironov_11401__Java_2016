package ru.kpfu.itis.Mironov.SE.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class LoginPageController {
    @Autowired
    ModelAndView modelLogin;
    @RequestMapping(value = "{path:login|logout}", method = RequestMethod.GET)
    public ModelAndView logInDoGet() {
        return modelLogin;
    }



}