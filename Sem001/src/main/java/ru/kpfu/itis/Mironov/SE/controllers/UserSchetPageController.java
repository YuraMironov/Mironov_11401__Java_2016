package ru.kpfu.itis.Mironov.SE.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.Mironov.SE.entities.MyUser;
import ru.kpfu.itis.Mironov.SE.entities.SafetyUser;
import ru.kpfu.itis.Mironov.SE.entities.Tarif;
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
    @Autowired
    ModelAndView modelUserSchet;
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView userSchetDoGet(HttpServletRequest request) {
        request.setAttribute(ATTR_USERSCHET_FORM, new UserSchetForm());
        modelUserSchet.getModelMap().addAttribute("tarifs", tarifsService.getAll());
        return modelUserSchet;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView userSchetDoPost(@Valid @ModelAttribute(ATTR_USERSCHET_FORM) UserSchetForm userSchetForm,
                                        BindingResult bindingResult,
                                        HttpServletRequest request,
                                        @RequestParam("tarif") int tarifId){
        MyUser user = userService.getByEmail(request.getRemoteUser());
        Tarif tarif = tarifsService.getById(user.getTarif().getIdTarif());
        modelUserSchet.getModelMap().put("tarifs", tarifsService.getAll());
        if (bindingResult.hasErrors()) {
            return modelUserSchet;
        }
        if(userSchetForm.getLastNow() != 99999){
            modelUserSchet.getModelMap().put("schetNumber",userSchetForm.getSchetNumber());
            modelUserSchet.getModelMap().put("lastNow", userSchetForm.getLastNow() +"");
            if ( tarif != null && tarifId == tarif.getIdTarif()) {
                int last = user.getLast();
                double cost = tarif.getCost();
                double dolg = (userSchetForm.getLastNow() - last) * cost;
                modelUserSchet.getModelMap().put("dolg", dolg +"");
            }else{
                modelUserSchet.getModelMap().put("date", userSchetForm.getDate());
                modelUserSchet.getModelMap().put("er_mes", "uncor_tarif");
                return modelUserSchet;
            }
        }else{
            modelUserSchet.getModelMap().put("er_mes", "changeSchetchik");
        }
        return modelUserSchet;
    }

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public ModelAndView userSchetPayDoGet(HttpServletRequest request){
        Double dolg = Double.parseDouble(request.getParameter("dolg").replace(",", "."));
        Integer lastNow = Integer.parseInt(request.getParameter("lastNow"));
        modelUserSchet.getModelMap().addAttribute("tarifs", tarifsService.getAll());


        if (dolg == null || dolg <= 0 || (lastNow+"").length() != 5){
            modelUserSchet.getModelMap().addAttribute("er_mes", "payError") ;
            return new ModelAndView("redirect:/userschet");
        }

        MyUser user = userService.getByEmail(request.getRemoteUser());
        user.setLast(Integer.parseInt(lastNow +""));
        userService.addEntity(user);
        modelUserSchet.getModelMap().clear();
        return new ModelAndView("redirect:/userschet");
    }

}
//,
//