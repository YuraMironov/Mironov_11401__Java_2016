package ru.kpfu.itis.Mironov.SE.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.Mironov.SE.entities.MyUser;
import ru.kpfu.itis.Mironov.SE.forms.ChangePassForm;
import ru.kpfu.itis.Mironov.SE.services.MyUserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by Юра on 19.04.2016.
 */
@Controller
@RequestMapping("/{path:changepass}")
public class ChangePasswordController {
    public static final String ATTR_CHANGEPASSWORD_FORM = "changepassword_form";
    @Autowired
    MyUserService userService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    private ModelAndView modelChP;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView chengePasswdDoPost(HttpServletRequest request) {
        request.setAttribute(ATTR_CHANGEPASSWORD_FORM, new ChangePassForm());
        return modelChP;
    }

    @Transactional
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView changePasswdDoPost(@Valid @ModelAttribute(ATTR_CHANGEPASSWORD_FORM) ChangePassForm cpf,
                                           BindingResult bindingResult) {
        MyUser user = userService.getByEmail(request.getRemoteUser());
        if (bindingResult.hasErrors()) {
            return modelChP;
        }
        if (cpf.getOldPass() != null)
            if (!MD5.md5Decoder(cpf.getOldPass()).equals(user.getPassword())) {
                modelChP.getModelMap().addAttribute("er_mes", "oldPass");
                modelChP.getModelMap().clear();
                return modelChP;
            } else {
                user.setPassword(MD5.md5Decoder(cpf.getPassword2()));
                userService.changePassword(user);
                modelChP.getModelMap().put("er_mes", "changePassReg");
                return modelChP;
            }
        return new ModelAndView("redirect:/error404");
    }
}
