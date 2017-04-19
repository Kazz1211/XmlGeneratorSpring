/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ja.xmlgeneratorspring.controllers;

import com.ja.xmlgeneratorspring.service.ProceduresCallService;
import com.ja.xmlgeneratorspring.service.ResponseGeneratorService;
import com.ja.xmlgeneratorspring.entity.Mecz;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Ja
 */
@Controller
public class ProceduresController {

    @Autowired
    private ProceduresCallService proceduresCallService;
    @Autowired
    private ResponseGeneratorService responseGeneratorService;

    @RequestMapping("/")
    public String proceduresView() {
        return "procedures";
    }

    @RequestMapping("/ban")
    public String banned() {
        return "banned";
    }

    @RequestMapping("/newban")
    public String newBan() {
        return "newban";
    }

    @RequestMapping("/denied")
    public String denied() {
        return "denied";
    }

    @RequestMapping("/select")
    @ResponseBody
    public void generate(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            String ip = request.getRemoteAddr();
            if (proceduresCallService.checkIfCallToExecute(session, ip, response)) {
                List<Mecz> results = proceduresCallService.getData(request);
                responseGeneratorService.prepareResponse(request, response, results);
            }
        } catch (IOException ex) {
            Logger.getLogger(ProceduresController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
