package ru.kpfu.itis.Mironov.SE.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.Mironov.SE.entities.Tarif;
import ru.kpfu.itis.Mironov.SE.services.TarifsService;

import java.util.List;

/**
 * Created by Юра on 19.04.2016.
 */
@Controller
@RequestMapping("/{path:tarifs}")
public class TarifsPageController {
    @Autowired
    TarifsService tarifsService;
    @Autowired
    ModelAndView modelTarifs;
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView tarifsDoGet(@RequestParam(value = "count", required = false) Integer count,
                              @PathVariable("path") String path){
        if(count == null || count < 1){
            return new ModelAndView("redirect:/" + path + "?count=1");
        }
        List<Tarif> tarifs = tarifsService.get10NewsByPageNumber(count);
        modelTarifs.getModelMap().addAttribute("count", count);
        modelTarifs.getModelMap().addAttribute("tarifs", tarifs);
        modelTarifs.getModelMap().addAttribute("tarifsSize", tarifsService.getAll().size());

        return modelTarifs;
    }
}
