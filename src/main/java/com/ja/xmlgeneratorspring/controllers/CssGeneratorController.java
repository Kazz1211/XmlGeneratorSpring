/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ja.xmlgeneratorspring.controllers;

import com.ja.xmlgeneratorspring.service.CssGeneratorService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Ja
 */
@Controller
@RequestMapping("/css")
public class CssGeneratorController {
    @Autowired
    private CssGeneratorService cssGeneratorService;

    @RequestMapping("/")
    public String cssGeneratorView() {
        return "css";
    }
    @RequestMapping("/generate")
    @ResponseBody
    public void generateCss(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment; filename=style.css");
        cssGeneratorService.generateCss(request, response);
    }
    
    public void setCssGeneratorService(CssGeneratorService cssGeneratorService) {
        this.cssGeneratorService = cssGeneratorService;
    }
   
}
