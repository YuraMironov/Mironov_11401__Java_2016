package ru.kpfu.itis.Mironov.SE.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.Mironov.SE.entities.News;
import ru.kpfu.itis.Mironov.SE.services.NewsesService;

import java.util.List;

/**
 * Created by Юра on 18.04.2016.
 */
@Controller
@RequestMapping("/{path:news}")
public class NewsesPageController {
    @Autowired
    NewsesService newsesService;
    @RequestMapping(method = RequestMethod.GET)
    public String newsesDoGet(@ModelAttribute("model") ModelMap model, @PathVariable("path") String path,
                              @RequestParam(value = "count", required = false) Integer count){
        if(count == null || count < 1){
            return "redirect:/" + path + "?count=1";
        }
        List<News> newses = newsesService.get10NewsByPageNumber(count);
        model.addAttribute("newses", newses);
        model.addAttribute("newsesSize", newsesService.getAll().size());
        model.addAttribute("count", count);

        return "Newses";
    }
}
