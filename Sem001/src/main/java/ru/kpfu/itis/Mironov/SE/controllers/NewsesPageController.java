package ru.kpfu.itis.Mironov.SE.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
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
    @Autowired
    ModelAndView modelNewses;
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView newsesDoGet(@PathVariable("path") String path,
                              @RequestParam(value = "count", required = false) Integer count){
        if(count == null || count < 1){
            return new ModelAndView("redirect:/" + path + "?count=1");
        }
        List<News> newses = newsesService.get10NewsByPageNumber(count);
        modelNewses.getModelMap().addAttribute("newses", newses);
        modelNewses.getModelMap().addAttribute("newsesSize", newsesService.getAll().size());
        modelNewses.getModelMap().addAttribute("count", count);

        return modelNewses;
    }
}
