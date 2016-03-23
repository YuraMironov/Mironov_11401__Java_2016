package ru.kpfu.itis.my.firstmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Юра on 22.03.2016.
 */
@Controller
@RequestMapping("result")
public class ResultController {
    @RequestMapping(method = RequestMethod.GET)
    public String getResult(ModelMap modelMap, @RequestParam(required = false) int result){
        modelMap.put("result", result);
        return "result";
    }
}
