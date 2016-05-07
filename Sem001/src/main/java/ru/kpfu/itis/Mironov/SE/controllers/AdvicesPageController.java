package ru.kpfu.itis.Mironov.SE.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.Mironov.SE.entities.Advice;
import ru.kpfu.itis.Mironov.SE.entities.CssNames;
import ru.kpfu.itis.Mironov.SE.forms.AdviceAddForm;
import ru.kpfu.itis.Mironov.SE.services.AdviceService;
import ru.kpfu.itis.Mironov.SE.services.CssNamesService;
import ru.kpfu.itis.Mironov.SE.services.MyUserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by Юра on 28.04.2016.
 */
@Controller
@RequestMapping("{path:advices}")
public class AdvicesPageController {
    public static final String ATTR_ADVICEADD_FORM = "adviceadd_form";
    @Autowired
    AdviceService adviceService;
    @Autowired
    CssNamesService cssNamesService;
    @Autowired
    MyUserService userService;
    @Autowired
    HttpServletRequest request;

    @RequestMapping(method = RequestMethod.GET)
    public String advicesDoGet(@ModelAttribute("model") ModelMap model) {
        List<Advice> advices = adviceService.findLast7();
        List<CssNames> styles = cssNamesService.getAll();
        model.addAttribute("styles", styles);
        model.addAttribute("advices", advices);
        model.addAttribute("allAdvices", adviceService.getAll());
        request.setAttribute(ATTR_ADVICEADD_FORM, new AdviceAddForm());
        return "Advices";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String advicesDoPost(@Valid @ModelAttribute(ATTR_ADVICEADD_FORM) AdviceAddForm adviceAddForm,
                                BindingResult bindingResult, @ModelAttribute("model") ModelMap model
//                                @RequestParam("title") String title, @RequestParam("body") String body,
//                                @RequestParam("filesrc") String filesrc
    ) {
        if (bindingResult.hasErrors()) {
            List<Advice> advices = adviceService.findLast7();
            List<CssNames> styles = cssNamesService.getAll();
            model.addAttribute("styles", styles);
            model.addAttribute("advices", advices);
            model.addAttribute("allAdvices", adviceService.getAll());
            model.addAttribute("validInfo", true);
            return "Advices";
        }
        Advice adv = new Advice();
        adv.setAdvname(adviceAddForm.getTitle());
        adv.setAdvbody(adviceAddForm.getBody());
        if (adviceAddForm.getFilesrc() != null)
            adv.setFilesrc(adviceAddForm.getFilesrc());
        System.out.println(request.getUserPrincipal());
        if (request.getUserPrincipal() != null)
            adv.setAuthor(userService.getByEmail(request.getUserPrincipal().getName()));
        if (adviceService.addEntity(adv).equals(adv))
            return "redirect:/advices";
        return "error404";
    }
}
