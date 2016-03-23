package Homework1.Task014.firstmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Юра on 21.03.2016.
 */
@Controller
@RequestMapping("/task11bgetdate")
public class GetDateController {
    @RequestMapping(method = RequestMethod.GET)
    public String getDatePage(ModelMap model){
        model.put("time", new java.util.Date());
        return "task11bGetDate";
    }
}
