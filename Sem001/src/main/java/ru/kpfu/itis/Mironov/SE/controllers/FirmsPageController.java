package ru.kpfu.itis.Mironov.SE.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.Mironov.SE.entities.Firm;
import ru.kpfu.itis.Mironov.SE.services.FirmService;

import java.util.List;

/**
 * Created by Юра on 15.04.2016.
 */
@Controller
@RequestMapping("/{path:firms}")
public class FirmsPageController {
    @Autowired
    FirmService firmService;
    @Autowired
    ModelAndView modelFirms;
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView firmsDoGet( @RequestParam(value = "count", required = false) Integer count,
                                    @PathVariable("path") String path){
        if (count == null || count < 1){
            return new ModelAndView("redirect:/" + path + "?count=1");
        }
        List<Firm> firms = firmService.get10NewsByPageNumber(count);
        modelFirms.getModelMap().addAttribute("firms", firms);
        modelFirms.getModelMap().addAttribute("firmsSize", firmService.getAll().size());
        modelFirms.getModelMap().addAttribute("count", count);
        return modelFirms;
    }
}
