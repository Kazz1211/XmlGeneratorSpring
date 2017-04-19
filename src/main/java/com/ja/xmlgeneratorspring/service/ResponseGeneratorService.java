/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ja.xmlgeneratorspring.service;

import com.google.gson.Gson;
import com.ja.xmlgeneratorspring.parsers.OgdlCreator;
import com.ja.xmlgeneratorspring.parsers.ToXml;
import com.ja.xmlgeneratorspring.entity.Mecz;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;

/**
 *
 * @author Ja
 */
@Service
public class ResponseGeneratorService {

    public void prepareResponse(HttpServletRequest request, HttpServletResponse response, List<Mecz> results) throws IOException {
        String format = request.getParameter("format");
        String filename = request.getParameter("procedure");
        setHeader(format, filename, response);
        boolean ifCss = checkIfCssRequired(request);
        generateOutput(format, results, ifCss, response);
    }

    private void setHeader(String format, String filename, HttpServletResponse response) {
        String header = "attachment; filename=" + filename;
        switch (format) {
            case "XML":
                header += (".xml");
                break;
            case "YAML":
                header += (".yml");
                break;
            case "JSON":
                response.setContentType("application/json");
                header += (".json");
                break;
            case "OGDL":
                header += (".ogdl");
                break;
            default:
                break;
        }
        response.setHeader("Content-Disposition", header);
    }

    private void generateOutput(String format, List<Mecz> list, boolean ifCss, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        switch (format) {
            case "XML":
                generateXml(list, ifCss, out);
                break;
            case "YAML":
                generateYaml(list, out);
                break;
            case "JSON":
                generateJson(list, out);
                break;
            case "OGDL":
                generateOgdl(list, out);
                break;
            default:
                break;
        }
    }

    private void generateXml(List<Mecz> list, boolean ifCss, PrintWriter out) {
        ToXml toxml = new ToXml();
        String xml = toxml.listToXml(list, ifCss);
        out.print(xml);
    }

    private void generateJson(List<Mecz> list, PrintWriter out) {
        Gson gson = new Gson();
        for (Mecz mecz : list) {
            gson.toJson(mecz, out);
        }
    }

    private void generateYaml(List<Mecz> list, PrintWriter out) {
        Yaml yaml = new Yaml();
        for (Mecz mecz : list) {
            String output = yaml.dump(mecz);
            out.print(output);
        }
    }
    
    private boolean checkIfCssRequired(HttpServletRequest request) {
        boolean ifCss;
        if (request.getParameter("css").equals("yes")) {
            ifCss = true;
        } else {
            return false;
        }
        return ifCss && request.getParameter("format").equals("XML");
    }

    private void generateOgdl(List<Mecz> list, PrintWriter out) {
        String output = OgdlCreator.collectionToOgdlString(list);
        out.print(output);
    }
}
