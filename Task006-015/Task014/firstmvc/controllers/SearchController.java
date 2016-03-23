package Homework1.Task014.firstmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Юра on 21.03.2016.
 */
@Controller
@RequestMapping("/search/{address}")
public class SearchController {
    @RequestMapping(method = RequestMethod.GET)
    public String searchPage(ModelMap model, @PathVariable String address){
        address = "/" + address;
        String name = "";
        String url = "'http://";
        if (address != null) {
            name = address.equals("/bing") | address.equals("/aol") ? "q" : address.equals("/yahoo") ? "p" : "wd";
            if (name.equals("wd") & !address.equals("/baidu")) {
                return "error404";
            }
            if (address.equals("/bing")) {
                url += "bing.com/search";
            } else {
                if (address.equals("/baidu")) {
                    url += "www.baidu.com/s";
                } else {
                    if (address.equals("/yahoo")) {
                        url += "search.yahoo.com/search";
                    } else
                        url += "search.aol.com/aol/search";
                }
            }
            model.put("name", name);
            model.put("url", url);
        }else {
            return "error404";
        }
        return "task11bSearch";
    }
}
