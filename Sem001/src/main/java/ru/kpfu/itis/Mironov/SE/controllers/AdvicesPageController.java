package ru.kpfu.itis.Mironov.SE.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.Mironov.SE.entities.Advice;
import ru.kpfu.itis.Mironov.SE.entities.CssNames;
import ru.kpfu.itis.Mironov.SE.services.AdviceService;
import ru.kpfu.itis.Mironov.SE.services.CssNamesService;
import ru.kpfu.itis.Mironov.SE.services.MyUserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Юра on 28.04.2016.
 */
@Controller
@RequestMapping("{path:advices}")
public class AdvicesPageController {
    @Autowired
    AdviceService adviceService;
    @Autowired
    CssNamesService cssNamesService;
    @Autowired
    MyUserService userService;
    @RequestMapping(method = RequestMethod.GET)
    public String advicesDoGet(@ModelAttribute("model")ModelMap model){
        List<Advice> advices = adviceService.findLast7();
        List<CssNames> styles = cssNamesService.getAll();
        model.addAttribute("styles", styles);
        model.addAttribute("advices", advices);
        model.addAttribute("allAdvices", adviceService.getAll());
        return "Advices";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String advicesDoPost(@RequestParam("title") String title, @RequestParam("body") String body,
                                      @RequestParam("filesrc") String filesrc, HttpServletRequest request){
        Advice adv = new Advice();
        adv.setAdvname(title);
        adv.setAdvbody(body);
        if (filesrc != null)
            adv.setFilesrc(filesrc);
        System.out.println(request.getUserPrincipal());
        if (request.getUserPrincipal() != null)
        adv.setAuthor(userService.getByEmail(request.getUserPrincipal().getName()));
        if(adviceService.addEntity(adv).equals(adv))
            return "redirect:/advices";
        return "error404";
    }
}
