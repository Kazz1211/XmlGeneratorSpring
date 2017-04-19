package com.ja.xmlgeneratorspring.parsers;

import com.ja.xmlgeneratorspring.entity.Mecz;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ja
 */
public class ToXml {
    public String listToXml(Collection results, boolean ifCss) {
        StringBuilder xml = new StringBuilder();
        xml.append("<?xml version=\"1.0\" encoding=\"iso-8859-2\" standalone=\"yes\" ?>\n");
        if (ifCss) {
            xml.append("<?xml-stylesheet type=\"text/css\" href=\"style.css\" ?>\n");
        }
        if (results != null) {
            xml.append("<dane>\n");
            try {
                for (Object o : results) {
                    xml.append(objectToXml(o));
                }
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(ToXml.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        xml.append("</dane>");
        return xml.toString();
    }

    private String objectToXml(Object o) throws IllegalArgumentException, IllegalAccessException {
        StringBuilder xml = new StringBuilder();
        xml.append("\t<").append(o.getClass().getSimpleName()).append(">\n");
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            xml.append("\t\t<")
                    .append(field.getName())
                    .append(">")
                    .append(field.get(o))
                    .append("</")
                    .append(field.getName())
                    .append(">\n");
        }
        xml.append("\t</").append(o.getClass().getSimpleName()).append(">\n");
        return xml.toString();
    }

}
