package ru.kpfu.itis.my.firstmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Юра on 22.03.2016.
 */
@Controller
@RequestMapping("process")
public class ProcessController {
    @RequestMapping( method = RequestMethod.GET)
    public String getPage(ModelMap model) {
        return "process";
    }
    @RequestMapping( method = RequestMethod.POST)
    public String processing(ModelMap model, @RequestParam(required = false, name = "oper") String s,
                            @RequestParam(required = false, name = "text") String text,
                            @RequestParam(required = false, name = "request")HttpServletRequest request) {
        System.out.println(request);
        int result = 0;
        if (s.equals("symbols")) {
            result = text.length();
        } else if (s.equals("words")) {
            result = text.split(" ").length;
        } else if (s.equals("paragraphs")) {
            result = text.split("\\n").length;
        } else if (s.equals("sentences")) {
            for (int i = 0; i < text.length(); i++) {
                if (".?!".contains(text.charAt(i) + "")) {
                    result++;
                }
            }
        }
        model.put("result", result);

        return "redirect:/result";
    }

}
