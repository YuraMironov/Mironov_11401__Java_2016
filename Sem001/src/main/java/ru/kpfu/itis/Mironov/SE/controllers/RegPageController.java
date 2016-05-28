package ru.kpfu.itis.Mironov.SE.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.Mironov.SE.entities.MyUser;
import ru.kpfu.itis.Mironov.SE.forms.RegistrationForm;
import ru.kpfu.itis.Mironov.SE.services.FirmsService;
import ru.kpfu.itis.Mironov.SE.services.MyUserService;
import ru.kpfu.itis.Mironov.SE.services.TarifsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    FirmsService firmsService;
    @Autowired
    MyUserService myUserService;
    @Autowired
    HttpServletRequest request;

    @RequestMapping(method = RequestMethod.GET)
    public String regDoGet(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("firms", firmsService.getAll());
        model.addAttribute("tarifs", tarifsService.getAll());
        request.setAttribute(ATTR_REGISTRATION_FORM, new RegistrationForm());
        return "Reg";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView regDoPost(@Valid @ModelAttribute(ATTR_REGISTRATION_FORM) RegistrationForm registrationForm,
                                  BindingResult bindingResult,
                                  @RequestParam("produce") long produce,
                                  @RequestParam("tarif") long tarif
    ) {
        ModelAndView mav = new ModelAndView("Reg");
        mav.getModelMap().put("firms", firmsService.getAll());
        mav.getModelMap().put("tarifs", tarifsService.getAll());
        if (bindingResult.hasErrors()) {
            return mav;
        }
        MyUser user = new MyUser();
        user.setLogin(registrationForm.getLogin());
        user.setPassword(MD5.md5Decoder(registrationForm.getPassword()));
        user.setEmail(registrationForm.getEmail());
        user.setTarif(tarifsService.getById(tarif));
        user.setFirm(firmsService.getById(produce));
        user.setLast(registrationForm.getLast());
        user.setRole("ROLE_USER");
        if (myUserService.addEntity(user).equals(user)) {
            mav.getModelMap().put("success_mes", true);
        } else {
            mav.getModelMap().put("er_mes", "repeat");
        }
        return mav;
    }
    @ResponseBody
    @RequestMapping(value = "/checkedEmail", method = RequestMethod.GET)
    public MyUser checkedEmailDoGet(HttpServletRequest request){
        String q = request.getParameter("q");
        return myUserService.getByEmail(q);
    }


}
