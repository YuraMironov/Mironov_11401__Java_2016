package ru.kpfu.itis.Mironov.SE.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.Mironov.SE.exceptions.MySiteException;
import ru.kpfu.itis.Mironov.SE.exceptions.MyUsernameNotFoundException;
import ru.kpfu.itis.Mironov.SE.services.MyUserService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Юра on 28.04.2016.
 */
@ControllerAdvice
public class ContollerHelper {
    @Autowired
    MyUserService userService;
    @ModelAttribute
    public void inputParameters(@ModelAttribute("model") ModelMap model, @PathVariable() String path,
                                       HttpServletRequest request){
        System.out.println("Page with URI \".../" + path +"\"  was open by " + request.getRemoteUser() + ".");
        model.addAttribute("currentUser",userService.getByEmail(request.getRemoteUser()));
        model.addAttribute("path", "/" + path.split("\\?")[0]);
    }
    @ExceptionHandler(MySiteException.class)
    public ModelAndView handlerMySiteException(@PathVariable() String path){
        System.out.println("ya tut");
        ModelAndView modelAndView = new ModelAndView("error404");
        modelAndView.getModelMap().addAttribute("path", " " + path + " " + this.getClass());
        return modelAndView;
    }
    @ExceptionHandler(MyUsernameNotFoundException.class)
    public String handlerUserNotFoundException(@PathVariable() String path, @ModelAttribute("model") ModelMap model){
        return "redirect:/"+path+"?error=usernamenotfound";
    }
}
