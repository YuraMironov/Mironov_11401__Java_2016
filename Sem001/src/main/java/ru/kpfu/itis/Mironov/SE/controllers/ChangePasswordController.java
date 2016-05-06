package ru.kpfu.itis.Mironov.SE.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.Mironov.SE.entities.MyUser;
import ru.kpfu.itis.Mironov.SE.services.MyUserService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Юра on 19.04.2016.
 */
@Controller
@RequestMapping("/{path:changepass}")
public class ChangePasswordController {
    @Autowired
    MyUserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String chengePasswdDoPost() {
        return "ChangePassword";
    }

    @Transactional
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView changePasswdDoPost(HttpServletRequest request,
                                           @RequestParam("oldPass") String oldPass,
                                           @RequestParam("pass") String pass,
                                           @RequestParam("newPass") String newPass){
        MyUser user = userService.getByEmail(request.getRemoteUser());
        ModelAndView mav = new ModelAndView("ChangePassword");
        if (oldPass != null)
            if (!MD5.md5Decoder(oldPass).equals(user.getPassword()) ) {
                mav.getModelMap().put("er_mes", "oldPass");
                return mav;
            } else {
                if(!pass.equals(newPass)) {
                    System.out.println("changepassssserror");
                }else{
                    user.setPassword( MD5.md5Decoder(newPass));
                    userService.changePassword(user);
                    mav.getModelMap().put("er_mes", "changePassReg");
                    return mav;
                }
            }
        return new ModelAndView("error404");
    }
}
