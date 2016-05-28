package ru.kpfu.itis.Mironov.SE.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.Mironov.SE.entities.MyUser;
import ru.kpfu.itis.Mironov.SE.entities.Tarif;
import ru.kpfu.itis.Mironov.SE.forms.RegistrationForm;
import ru.kpfu.itis.Mironov.SE.forms.UserSchetForm;
import ru.kpfu.itis.Mironov.SE.services.MyUserService;
import ru.kpfu.itis.Mironov.SE.services.TarifsService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by Юра on 19.04.2016.
 */
@Controller
@RequestMapping("/{path:userschet}")
public class UserSchetPageController {
    public static final String ATTR_USERSCHET_FORM = "userschet_form";
    @Autowired
    TarifsService tarifsService;
    @Autowired
    MyUserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView userSchetDoGet(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("UserSchet");
        MyUser user = userService.getByEmail(request.getRemoteUser());
        mav.getModelMap().put("activeUser", user);
        mav.getModelMap().addAttribute("tarifs", tarifsService.getAll());
        request.setAttribute(ATTR_USERSCHET_FORM, new UserSchetForm());
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView userSchetDoPost(@Valid @ModelAttribute(ATTR_USERSCHET_FORM) UserSchetForm userSchetForm,
                                        BindingResult bindingResult,
                                        HttpServletRequest request,
                                        @RequestParam("tarif") int tarifId){
        ModelAndView mav = new ModelAndView("UserSchet");
        MyUser user = userService.getByEmail(request.getRemoteUser());
        Tarif tarif = tarifsService.getById(user.getTarif().getIdTarif());
        mav.getModelMap().put("activeUser", user);
        mav.getModelMap().put("tarifs", tarifsService.getAll());
        if (bindingResult.hasErrors()) {
            return mav;
        }
        if(userSchetForm.getLastNow() != 99999){
            mav.getModelMap().put("schetNumber",userSchetForm.getSchetNumber());
            mav.getModelMap().put("lastNow", userSchetForm.getLastNow() +"");
            if ( tarif != null && tarifId == tarif.getIdTarif()) {
                int last = user.getLast();
                double cost = tarif.getCost();
                double dolg = (userSchetForm.getLastNow() - last) * cost;
                mav.getModelMap().put("dolg", dolg +"");
            }else{
                mav.getModelMap().put("date", userSchetForm.getDate());
                mav.getModelMap().put("er_mes", "uncor_tarif");
                return mav;
            }
        }else{
            mav.getModelMap().put("er_mes", "changeSchetchik");
        }
        return mav;
    }

    @RequestMapping(value = "/pay", method = RequestMethod.GET)
    public ModelAndView userSchetPayDoGet(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("UserSchet");
        Double dolg = Double.parseDouble(request.getParameter("dolg").replace(",", "."));
        Integer lastNow = Integer.parseInt(request.getParameter("lastNow"));
        mav.getModelMap().addAttribute("tarifs", tarifsService.getAll());
        System.out.println(dolg  + " " + lastNow);
        if (dolg == null || dolg <= 0 || (lastNow+"").length() != 5){
            mav.getModelMap().addAttribute("er_mes", "payError") ;
            return mav;
        }
        MyUser user = userService.getByLogin(request.getRemoteUser());
        user.setLast(Integer.parseInt(lastNow +""));
        userService.paySchet(user);
        return mav;
    }

}
//,
//