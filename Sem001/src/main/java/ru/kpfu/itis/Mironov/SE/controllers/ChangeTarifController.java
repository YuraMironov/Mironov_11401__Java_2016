package ru.kpfu.itis.Mironov.SE.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.Mironov.SE.entities.ClaimTarif;
import ru.kpfu.itis.Mironov.SE.entities.Tarif;
import ru.kpfu.itis.Mironov.SE.services.ClaimsTarifService;
import ru.kpfu.itis.Mironov.SE.services.FirmsService;
import ru.kpfu.itis.Mironov.SE.services.MyUserService;
import ru.kpfu.itis.Mironov.SE.services.TarifsService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Юра on 10.05.2016.
 */
@Controller
@RequestMapping("/{path:changetarif}")
public class ChangeTarifController {
    @Autowired
    FirmsService firmsService;
    @Autowired
    TarifsService tarifsService;
    @Autowired
    MyUserService userService;
    @Autowired
    ClaimsTarifService claimsTarifService;
    @RequestMapping(method = RequestMethod.GET)
    public String changeTarifDoPost(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("firms", firmsService.getAll());
        return "ChangeTarif";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String changeTarifDoPost(@ModelAttribute("model") ModelMap model,
                                    HttpServletRequest request, @RequestParam("produce") Long produce,
                                    @RequestParam("tarif") Long tarif, @RequestParam("comment") String comment) {
        model.addAttribute("firms", firmsService.getAll());
        ClaimTarif ct = new ClaimTarif();
        if (firmsService.getById(produce) != null) {
            ct.setNewtarifid(tarif);
            ct.setComment(comment);
            ct.setUserid(userService.getByEmail(request.getRemoteUser()).getId());
            claimsTarifService.addEntity(ct);
            model.addAttribute("message", "success");
        }else{
        model.addAttribute("message", "error");}
        return "ChangeTarif";
    }

    @ResponseBody
    @RequestMapping(value = "/tarifs", method = RequestMethod.GET)
    public List<Tarif> changeTarifDoGET(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("firms", firmsService.getAll());
        return tarifsService.getAll();
    }
}
