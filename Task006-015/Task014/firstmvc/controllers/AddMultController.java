package Homework1.Task014.firstmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Юра on 22.03.2016.
 */
@Controller
@RequestMapping("/{address}/{first}/{second}")
public class AddMultController {
    @RequestMapping
    public String mathPage(ModelMap model, @PathVariable String address, @PathVariable int first, @PathVariable int second) {
        model.put("first", first);
        model.put("second", second);

        if (address.equals("mult")) {
            model.put("res", first * second);
            model.put("action", " * ");
        } else {
            if (address.equals("add")) {
                model.put("res", first + second);
                model.put("action", " + ");
            } else {
                return "error404";
            }
        }
        return "task11bCalc";
    }
}
