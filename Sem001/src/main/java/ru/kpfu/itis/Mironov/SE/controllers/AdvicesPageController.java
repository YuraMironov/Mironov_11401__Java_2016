package ru.kpfu.itis.Mironov.SE.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
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
    @Autowired
    ModelAndView modelAdvices;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView advicesDoGet(@ModelAttribute("model") ModelMap model) {
        List<Advice> advices = adviceService.findLast7();
        List<CssNames> styles = cssNamesService.getAll();
        modelAdvices.getModelMap().addAttribute("styles", styles);
        modelAdvices.getModelMap().addAttribute("advices", advices);
        modelAdvices.getModelMap().addAttribute("allAdvices", adviceService.getAll());
        request.setAttribute(ATTR_ADVICEADD_FORM, new AdviceAddForm());
        return modelAdvices;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView advicesDoPost(@Valid @ModelAttribute(ATTR_ADVICEADD_FORM) AdviceAddForm adviceAddForm,
                                BindingResult bindingResult,
                                @ModelAttribute("model") ModelMap model) {
        if (bindingResult.hasErrors()) {
            List<Advice> advices = adviceService.findLast7();
            List<CssNames> styles = cssNamesService.getAll();
            modelAdvices.getModelMap().addAttribute("styles", styles);
            modelAdvices.getModelMap().addAttribute("advices", advices);
            modelAdvices.getModelMap().addAttribute("allAdvices", adviceService.getAll());
            modelAdvices.getModelMap().addAttribute("validInfo", true);
            return modelAdvices;
        }
        Advice adv = new Advice();
        adv.setAdvname(adviceAddForm.getTitle());
        adv.setAdvbody(adviceAddForm.getBody());
        if (adviceAddForm.getFilesrc() != null)
            adv.setFilesrc(adviceAddForm.getFilesrc());
        if (request.getUserPrincipal() != null)
            modelAdvices.getModelMap().clear();
            adv.setAuthor(userService.getByEmail(request.getRemoteUser()));
        if (adviceService.addEntity(adv).equals(adv))
            return new ModelAndView("redirect:/advices");
        return new ModelAndView("error404");
    }
}
