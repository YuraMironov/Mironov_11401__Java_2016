package ru.kpfu.itis.Mironov.SE.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.Mironov.SE.entities.MyUser;
import ru.kpfu.itis.Mironov.SE.services.FirmsService;
import ru.kpfu.itis.Mironov.SE.services.MyUserService;
import ru.kpfu.itis.Mironov.SE.services.TarifsService;

/**
 * Created by Юра on 13.04.2016.
 */
@Controller
@RequestMapping("/{path:reg}")
public class RegPageController {
    @Autowired
    TarifsService tarifsService;
    @Autowired
    FirmsService firmsService;
    @Autowired
    MyUserService myUserService;

    @RequestMapping(method = RequestMethod.GET)
    public String regDoGet(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("firms", firmsService.getAll());
        model.addAttribute("tarifs", tarifsService.getAll());
        return "Reg";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView regDoPost(@RequestParam("login") String login, @RequestParam("pass") String pass,
                                  @RequestParam("pass2") String pass2, @RequestParam("email") String email,
                                  @RequestParam("produce") long produce, @RequestParam("tarif") long tarif,
                                  @RequestParam("last") int last) {
        ModelAndView mav = new ModelAndView("Reg");
        if (pass.equals(pass2) && myUserService.getByEmail(email) == null) {
            MyUser user = new MyUser();
            user.setLogin(login);
            user.setPassword(MD5.md5Decoder(pass));
            user.setEmail(email);
            user.setUserProduce(produce);
            user.setUserTarif(tarif);
            user.setLast(last);
            user.setRole("ROLE_USER");
            mav.getModelMap().put("firms", firmsService.getAll());
            mav.getModelMap().put("tarifs", tarifsService.getAll());
            if (myUserService.addEntity(user).equals(user)){
                mav.getModelMap().put("success_mes", true);
            }else{
                mav.getModelMap().put("er_mes", "repeat");
            }

        }else{
            if (pass.equals(pass2))
                mav.getModelMap().put("er_mes", "repeatEmail");
        }
        return mav;
    }


}
