package Homework1.Task014.firstmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Alexander on 09/03/2016.
 */
@Controller
@RequestMapping("/hi")
public class HelloController {
    @RequestMapping(method = RequestMethod.GET)

    public String hiPage(ModelMap model) {
        model.put("time", new java.util.Date());
        return "hi";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String hiPage(ModelMap model, @RequestParam(required = false) String name) {
        if (!name.isEmpty()) {
            model.put("name", name);
        } else {
            model.put("name", "Anonymous");
        }
        return "hi";
    }
}
