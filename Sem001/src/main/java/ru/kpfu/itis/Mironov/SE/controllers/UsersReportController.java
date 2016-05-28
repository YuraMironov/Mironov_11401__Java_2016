package ru.kpfu.itis.Mironov.SE.controllers;

import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import ru.kpfu.itis.Mironov.SE.components.UserPdfCreator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Юра on 11.05.2016.
 */
//@Controller
//@RequestMapping("/{path:admin}/allusers/document")
public class UsersReportController extends AbstractController{

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String output =
                ServletRequestUtils.getStringParameter(request, "output");


        if(output ==null || "".equals(output)){
            //return normal view
            return new ModelAndView("error404");

        }else if("PDF".equals(output.toUpperCase())){
            //return excel view
            return new ModelAndView("pdfRevenueSummary");

        }else{
            //return normal view
            return new ModelAndView("error404");

        }
    }
}
