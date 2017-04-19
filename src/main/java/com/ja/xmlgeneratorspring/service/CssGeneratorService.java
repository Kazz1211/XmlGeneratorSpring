/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ja.xmlgeneratorspring.service;

import java.io.IOException;
import com.ja.xmlgeneratorspring.entity.Mecz;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ja
 */
@Service
public class CssGeneratorService {
    public void generateCss(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            Class c = new Mecz().getClass();
            out.print(writeDaneStyle());
            out.print(writeTableHeader(request,c));
            out.print(writeObjectStyle(request, c));
            out.print(writeHoverStyle(request, c));
            out.print(writeActiveStyle(request,c));
            out.print(writeEvenAndOddStyle(request, c));
            out.print(writeCellsStyle(c));
        } catch (IOException ex) {
            Logger.getLogger(CssGeneratorService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
    }
    private String writeTableHeader(HttpServletRequest request, Class c) {
        StringBuilder builder = new StringBuilder();
        Field[] fields = c.getDeclaredFields();
        String borderColor = request.getParameter("ko");
        for (Field f : fields) {
            builder.append("\t").append(c.getSimpleName()).append(":first-child ").append(f.getName()).append(":before {\n");
            builder.append("\t\tdisplay: block;\n");
            builder.append("\t\tcolor: black;\n");
            builder.append("\t\theight: 40px;\n");
            builder.append("\t\ttext-decoration: none;\n");
            builder.append("\t\tbackground-color: gray;\n");
            builder.append("\t\tborder: 1px dotted;\n");
            builder.append("\t\tborder-color: ").append(borderColor).append(";\n");
            builder.append("\t\tfont-weight: bold;\n");
            builder.append("\t\tcontent: \"").append(f.getName()).append("\";\n");
            builder.append("\t}\n");
        }
        return builder.toString();
    }

    private String writeCellsStyle(Class c) {
        StringBuilder builder = new StringBuilder();
        Field[] fields = c.getDeclaredFields();
        for (Field f : fields) {
            builder.append("\t").append(c.getSimpleName()).append(" > ").append(f.getName()).append(" {\n");
            builder.append("\t\tdisplay: table-cell;\n");
            builder.append("\t\tborder: 1px dotted;\n");
            builder.append("\t\twidth: 6%;\n");
            builder.append("\t}\n");
        }
        return builder.toString();
    }

    private String writeDaneStyle() {
        StringBuilder builder = new StringBuilder();
        builder.append("\tdane {\n");
        builder.append("\t\tmargin: auto;\n");
        builder.append("\t\tdisplay: table;\n");
        builder.append("\t\twidth: 90%;\n");
        builder.append("\t}\n");
        return builder.toString();
    }

    private String writeHoverStyle(HttpServletRequest request, Class c) {
        Field[] fields = c.getDeclaredFields();
        StringBuilder builder = new StringBuilder();
        String hoverColor = request.getParameter("kpn");
        builder.append("\t");
        for (int i = 0; i < fields.length - 1; i++) {
            builder.append(fields[i].getName()).append(":hover,");
        }
        builder.append(fields[fields.length - 1].getName()).append(":hover");
        builder.append(" {\n");
        builder.append("\t\tcolor: ").append(hoverColor).append(";\n");
        builder.append("\t}\n");
        return builder.toString();
    }

    private String writeActiveStyle(HttpServletRequest request, Class c) {
        Field[] fields = c.getDeclaredFields();
        StringBuilder builder = new StringBuilder();
        String activeColor = request.getParameter("kpk");
                builder.append("\t");
        for (int i = 0; i < fields.length - 1; i++) {
            builder.append(fields[i].getName()).append(":active,");
        }
        builder.append(fields[fields.length - 1].getName()).append(":active");
        builder.append(" {\n");
        builder.append("\t\tcolor: ").append(activeColor).append(";\n");
        builder.append("\t}\n");
        return builder.toString();
    }

    private String writeEvenAndOddStyle(HttpServletRequest request, Class c) {
        StringBuilder builder = new StringBuilder();
        String oddBackgroundColor = request.getParameter("kn");
        String evenBackgroundColor = request.getParameter("kp");
        builder.append("\t").append(c.getSimpleName()).append(":nth-child(2n) {\n");
        builder.append("\t\tbackground-color: ").append(evenBackgroundColor).append(";\n");
        builder.append("\t}\n");
        builder.append("\t").append(c.getSimpleName()).append(":nth-child(2n+1) {\n");
        builder.append("\t\tbackground-color: ").append(oddBackgroundColor).append(";\n");
        builder.append("\t}\n");
        return builder.toString();
    }

    private String writeObjectStyle(HttpServletRequest request, Class c) {
        StringBuilder builder = new StringBuilder();
        String italic = request.getParameter("kursywa");
        String weight = request.getParameter("pogrubienie");
        String underline = request.getParameter("podkreslenie");
        String fontSize = request.getParameter("wielkosc");
        String color = request.getParameter("kolor");
        String borderColor = request.getParameter("ko");
        builder.append("\t").append(c.getSimpleName()).append(" {\n");
        builder.append("\t\tdisplay: table-row;\n");
        builder.append("\t\tborder: 1px dotted;\n");
        builder.append("\t\tborder-color: ").append(borderColor).append(";\n");
        builder.append("\t\tcolor: ").append(color).append(";\n");
        builder.append("\t\tfont-style: ").append(italic).append(";\n");
        builder.append("\t\tfont-size: ").append(fontSize).append(";\n");
        builder.append("\t\tfont-weight: ").append(weight).append(";\n");
        builder.append("\t\ttext-decoration: ").append(underline).append(";\n");
        builder.append("\t\tborder-collapse: collapse;\n");
        builder.append("\t\tpadding: 10px 10px 10px 10px;\n");
        builder.append("\t}\n");
        return builder.toString();
    }
}
