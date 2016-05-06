package ru.kpfu.itis.Mironov.SE.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.Mironov.SE.entities.MyUser;
import ru.kpfu.itis.Mironov.SE.entities.Tarif;
import ru.kpfu.itis.Mironov.SE.services.MyUserService;
import ru.kpfu.itis.Mironov.SE.services.TarifsService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Юра on 19.04.2016.
 */
@Controller
@RequestMapping("/{path:userschet}")
public class UserSchetPageController {
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
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView userSchetDoPost(HttpServletRequest request,
                                        @RequestParam("schetNumber") int schetNumber,
                                        @RequestParam("date") String date,
                                        @RequestParam("lastNow") int lastNow,
                                        @RequestParam("tarif") int tarifId){
        ModelAndView mav = new ModelAndView("UserSchet");

        MyUser user = userService.getByEmail(request.getRemoteUser());
        Tarif tarif = tarifsService.getById(user.getUserTarif());
        mav.getModelMap().put("activeUser", user);
        mav.getModelMap().put("tarifs", tarifsService.getAll());
        if(lastNow != 99999){
            mav.getModelMap().put("schetNumber",schetNumber);
            mav.getModelMap().put("lastNow", lastNow);
            if ( tarif != null && tarifId == tarif.getIdTarif()) {
                int last = user.getLast();
                double cost = tarif.getCost();
                double dolg = (lastNow - last) * cost;
                mav.getModelMap().put("dolg", dolg);
            }else{
                mav.getModelMap().put("date", date);
                mav.getModelMap().put("er_mes", "uncor_tarif");
                return mav;
            }
        }else{
            mav.getModelMap().put("er_mes", "changeSchetchik");
        }
        return mav;
    }

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public ModelAndView userSchetPayDoGet(HttpServletRequest request,
                                          @RequestParam("dolg") Integer dolg,
                                          @RequestParam("lastNow") String lastNow){
        ModelAndView mav = new ModelAndView("UserSchet");
        System.out.println(dolg  + " " + lastNow);
        if (dolg == null || dolg <= 0){
            return mav;
        }
        MyUser user = userService.getByLogin(request.getRemoteUser());
        user.setLast(Integer.parseInt(lastNow));
        userService.paySchet(user);
        return mav;
    }

}
//,
//