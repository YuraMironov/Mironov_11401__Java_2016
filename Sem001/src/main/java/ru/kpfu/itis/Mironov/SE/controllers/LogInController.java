package ru.kpfu.itis.Mironov.SE.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class LogInController {
    @RequestMapping(value = "{path:login}", method = RequestMethod.GET)
    public ModelAndView logInDoGet() {
        ModelAndView mav = new ModelAndView("security/login");
        return mav;
    }

    @RequestMapping(value = "{path:login-failure}", method = RequestMethod.GET)
    public String logInFailure() {
        return "security/login-failure";
    }

    @RequestMapping(value = "{path:logout}", method = RequestMethod.GET)
    public ModelAndView logout(@ModelAttribute("er_mes") String erMes){
        System.out.println(erMes + "********");
        ModelAndView mav = new ModelAndView("security/login");
        mav.getModelMap().put("er_mes", erMes);
        return mav;
    }


}