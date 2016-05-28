package ru.kpfu.itis.Mironov.SE.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.Mironov.SE.entities.Firm;
import ru.kpfu.itis.Mironov.SE.services.FirmsService;

import java.util.List;

/**
 * Created by Юра on 15.04.2016.
 */
@Controller
@RequestMapping("/{path:firms}")
public class FirmsPageController {
    @Autowired
    FirmsService firmsService;
    @RequestMapping(method = RequestMethod.GET)
    public String firmsDoGet(@ModelAttribute("model") ModelMap model, @RequestParam(value = "count", required = false) Integer count,
                             @PathVariable("path") String path){
        if (count == null || count < 1){
            return "redirect:/" + path + "?count=1";
        }
        List<Firm> firms = firmsService.get10NewsByPageNumber(count);
        model.addAttribute("firms", firms);
        model.addAttribute("firmsSize", firmsService.getAll().size());
        model.addAttribute("count", count);
        return "Firms";
    }
}
