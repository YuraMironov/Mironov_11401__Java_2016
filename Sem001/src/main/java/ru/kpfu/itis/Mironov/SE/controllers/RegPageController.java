package ru.kpfu.itis.Mironov.SE.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.Mironov.SE.entities.MyUser;
import ru.kpfu.itis.Mironov.SE.forms.RegistrationForm;
import ru.kpfu.itis.Mironov.SE.services.FirmService;
import ru.kpfu.itis.Mironov.SE.services.MyUserService;
import ru.kpfu.itis.Mironov.SE.services.TarifsService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by Юра on 13.04.2016.
 */
@Controller
@RequestMapping("/{path:reg}")
public class RegPageController {
    public static final String ATTR_REGISTRATION_FORM = "registration_form";
    @Autowired
    TarifsService tarifsService;
    @Autowired
    FirmService firmService;
    @Autowired
    MyUserService myUserService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    ModelAndView modelReg;
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView regDoGet(@ModelAttribute("model") ModelMap model) {
        modelReg.getModelMap().addAttribute("firms", firmService.getAll());
        modelReg.getModelMap().addAttribute("tarifs", tarifsService.getAll());
        request.setAttribute(ATTR_REGISTRATION_FORM, new RegistrationForm());
        return modelReg;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView regDoPost(@Valid @ModelAttribute(ATTR_REGISTRATION_FORM) RegistrationForm registrationForm,
                                  BindingResult bindingResult,
                                  @RequestParam("produce") long produce,
                                  @RequestParam("tarif") long tarif) {
        modelReg.getModelMap().put("firms", firmService.getAll());
        modelReg.getModelMap().put("tarifs", tarifsService.getAll());
        if (bindingResult.hasErrors()) {
            return modelReg;
        }
        MyUser user = new MyUser();
        user.setLogin(registrationForm.getLogin());
        user.setPassword(MD5.md5Decoder(registrationForm.getPassword()));
        user.setEmail(registrationForm.getEmail());
        user.setTarif(tarifsService.getById(tarif));
        user.setFirm(firmService.getById(produce));
        user.setLast(registrationForm.getLast());
        user.setRole("ROLE_USER");
        if (myUserService.addEntity(user).equals(user)) {
            modelReg.getModelMap().put("success_mes", true);
        } else {
            modelReg.getModelMap().put("er_mes", "repeat");
        }
        return modelReg;
    }
    @ResponseBody
    @RequestMapping(value = "/checkedEmail", method = RequestMethod.GET)
    public MyUser checkedEmailDoGet(HttpServletRequest request){
        String q = request.getParameter("q");
        return myUserService.getByEmail(q);
    }


}
