package ru.kpfu.itis.Mironov.SE.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.Mironov.SE.entities.MyUser;
import ru.kpfu.itis.Mironov.SE.services.MyUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

/**
 * Created by Юра on 28.04.2016.
 */
@ControllerAdvice
public class ControllerHelper {
    private static Logger logger = Logger.getLogger(ControllerHelper.class);
    @Autowired
    MyUserService userService;
    @Autowired
    HttpServletRequest request;
    @ModelAttribute
    public void inputParameters(@ModelAttribute("model") ModelMap model,
                                @PathVariable() String path,
                                Principal principal){
        MyUser user = null;
        if(principal != null){
            user = (MyUser) ((Authentication) principal).getPrincipal();
        }
        String INFO = "Page with URI \".../" + path +"\" was open";
        INFO += user == null ? "." : " by " + user.getEmail() + "."  + request.getMethod() + "" + request.getRequestURI();
        logger.info(INFO);
        model.addAttribute("currentUser",user != null ? user.getSafetyUser() : user);
        model.addAttribute("path", "/" + path.split("\\?")[0]);
    }
}
