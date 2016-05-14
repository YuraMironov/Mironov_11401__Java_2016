package ru.kpfu.itis.Mironov.SE.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.Mironov.SE.entities.ClaimTarif;
import ru.kpfu.itis.Mironov.SE.entities.Tarif;
import ru.kpfu.itis.Mironov.SE.services.ClaimTarifService;
import ru.kpfu.itis.Mironov.SE.services.FirmService;
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
    FirmService firmService;
    @Autowired
    TarifsService tarifsService;
    @Autowired
    MyUserService userService;
    @Autowired
    ClaimTarifService claimTarifService;
    @Autowired
    private ModelAndView modelChT;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView changeTarifDoPost() {
        modelChT.getModelMap().addAttribute("firms", firmService.getAll());
        return modelChT;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView changeTarifDoPost(HttpServletRequest request,
                                          @RequestParam("produce") Long produce,
                                          @RequestParam("tarif") Long tarif,
                                          @RequestParam("comment") String comment) {
        modelChT.getModelMap().addAttribute("firms", firmService.getAll());
        ClaimTarif ct = new ClaimTarif();
        if (firmService.getById(produce) != null) {
            ct.setNewtarifid(tarif);
            ct.setComment(comment);
            ct.setUserid(userService.getByEmail(request.getRemoteUser()).getId());
            claimTarifService.addEntity(ct);
            modelChT.getModelMap().clear();
            modelChT.getModelMap().addAttribute("message", "success");
        } else {
            modelChT.getModelMap().addAttribute("message", "error");
        }
        return modelChT;
    }

    @ResponseBody
    @RequestMapping(value = "/tarifs", method = RequestMethod.GET)
    public List<Tarif> changeTarifDoGET(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("firms", firmService.getAll());
        return tarifsService.getAll();
    }
}
